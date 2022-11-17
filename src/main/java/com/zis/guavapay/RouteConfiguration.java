package com.zis.guavapay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    private final String parcelUri;
    private final String userUri;

    public RouteConfiguration(@Value("${service.parcel.uri}") String parcelUri,
                              @Value("${service.user.uri}") String userUri) {
        this.parcelUri = parcelUri;
        this.userUri = userUri;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/users/**")
                        .uri(userUri))
                .build();
    }

}
