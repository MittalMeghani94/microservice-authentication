package com.demo.swiggy.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

	@Autowired
	private RouteValidator validator;
	
	@Autowired
	private RestTemplate template;

	public AuthenticationFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange,chain) -> {
			if(validator.isSecured.test(exchange.getRequest())) {
				if(!exchange.getRequest().getHeaders().containsKey("AUTHORIZATION")) {
					throw new RuntimeException("missing authorization header");
				}
				
				String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if(authHeader !=null && authHeader.startsWith("Bearer ")) {
					authHeader = authHeader.substring(7);
				}
				
				try {
					
					//final String authServiceBaseURL = "http://AUTH-SERVICE";
					final String s1 ="http://localhost:8989/auth";
					
				//	String url = "http://AUTH-SERVICE//validate?token=" + authHeader;
				
					String str =  template.getForObject(s1 + "/validate?token="+authHeader,
							String.class );
					
				}
				catch (Exception e) {
					System.out.println("ex............."+e);
					throw new RuntimeException("unauthorized access");
				}
			}
				
			return chain.filter(exchange);
			});
		
		
	}
	
	public static class Config {

	}

	

}
