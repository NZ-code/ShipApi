package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route("ships", r -> r
						.host("localhost:8080")
						.and()
						.path("/api/ships/{shipId}", "/api/ships")
						.uri("http://localhost:8081")
				)
				.route("humans", r -> r.host("localhost:8080")
						.and()
						.path("/api/humans", "/api/humans/**",
								"/api/ships/{shipId}/humans","/api/ships/{shipId}/humans/{humanId}")
						.uri("http://localhost:8082")
				)
				.build();
	}
}

