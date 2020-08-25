package com.example.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class ReservationHttpConfiguration {

    @Bean
    RouterFunction<ServerResponse> routes(ReservationRepository rr) {

        return route()
                .GET("/reservations", serverRequest -> ok().body(rr.findAll(), Reservation.class))

                .build();


    }

}
