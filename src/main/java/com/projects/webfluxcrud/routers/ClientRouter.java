package com.projects.webfluxcrud.routers;

import com.projects.webfluxcrud.handlers.ClientHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class ClientRouter {

    @Bean
    public RouterFunction<ServerResponse> route(ClientHandler clientHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/clients")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        clientHandler::getAllClients)
                .andRoute(RequestPredicates.GET("/clients/{id}")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        clientHandler::getClientById);
    }
}
