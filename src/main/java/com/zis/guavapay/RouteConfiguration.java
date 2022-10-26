package com.zis.guavapay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    final String parcelUri;
    final String userUri;

    public RouteConfiguration(@Value("${service.parcel.uri}") String parcelUri,
                              @Value("${service.user.uri}") String userUri) {
        this.parcelUri = parcelUri;
        this.userUri = userUri;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("statistic_id", r -> r.path("/parcels/**")
                        .uri(parcelUri)
                )
                .route("user_id", r -> r.path("/users/**")
                        .uri(userUri)
                )
                .build();
    }

}
