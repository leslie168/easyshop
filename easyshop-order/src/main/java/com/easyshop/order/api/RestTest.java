package com.easyshop.order.api;


import com.easyshop.order.clientlib.customer.CustomerClient;
import com.easyshop.order.clientlib.customer.CustomerView;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Collection;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@EnableOAuth2Client
@Configuration
public class RestTest {

    @Autowired
    private CustomerClient customerClient;

    //@Autowired
    //private RestTemplate restTemplate;
    
   /* @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    */
    private static final String AUTHORIZATION_HEADER = "Authorization";
    
    @Autowired
    private OAuth2ClientContext oauth2ClientContext;
    private static final String BEARER_TOKEN_TYPE = "Bearer";
    
    @RequestMapping(value = "/custview/{userId}", method = RequestMethod.GET)
    CustomerView getCustomerViewByUserId(@PathVariable String userId) {
    	
      CustomerView custview=	customerClient.getCustomerViewByUserId(userId);
      return custview;
    
    }

    @RequestMapping(value = "/custview2/{userId}", method = RequestMethod.GET)
    CustomerView getCustomerViewByUserId2(@PathVariable String userId) {
    	
   
    	RestTemplate restTemplate=new RestTemplate();
    	String url = "http://localhost:8001/"+userId;
    	//String url = "http://customer-service/"+userId;
    	HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+ oauth2ClientContext.getAccessToken());
        //System.out.println(accessToken);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<CustomerView> response = 
          	  restTemplate.exchange(url , HttpMethod.GET,entity,CustomerView.class);
    //    restTemplate.exchange(requestEntity, responseType)
      return response.getBody();
   
    
    }
    @RequestMapping(value = "/custview3/{userId}", method = RequestMethod.GET)
    CustomerView getCustomerViewByUserId3(@PathVariable String userId) {
    	 ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
         resourceDetails.setUsername("user");
         resourceDetails.setPassword("password");
         resourceDetails.setAccessTokenUri("http://localhost:9999/uaa/oauth/token");
         resourceDetails.setClientId("acme");
         resourceDetails.setClientSecret("acmesecret");
         resourceDetails.setGrantType("password");
        // resourceDetails.setScope(asList("read", "write"));

         DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();

         OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);
       //  restTemplate.setMessageConverters(asList(new MappingJackson2HttpMessageConverter()));

         final CustomerView result = restTemplate.getForObject("http://localhost:8001/"+userId, CustomerView.class);
    	   
    	return result;
    
    }

    
}
