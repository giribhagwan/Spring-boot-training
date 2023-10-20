package com.session14.gatewayService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    @Bean
    public RouteLocator myRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/v1/user*/**")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("user")
                                .setFallbackUri("forward:/fallback")))
                        .uri("lb://USER-SERVICE"))
                .route(p -> p
                        .path("/api/v1/product*/**")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("productCatalog")
                                .setFallbackUri("forward:/fallback")))
                        .uri("lb://PRODUCT-CATALOG-SERVICE"))
                .route(p -> p
                        .path("/api/v1/order*/**")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("order")
                                .setFallbackUri("forward:/fallback")))
                        .uri("lb://ORDER-MANAGMENT-SERVICE"))
                .build();
    }
    @RequestMapping("/fallback")
    public ResponseEntity<String> fallback(){
        return new ResponseEntity<>("Service taking more time as expected, please contact to admin",
                HttpStatus.GATEWAY_TIMEOUT);
    }
}
