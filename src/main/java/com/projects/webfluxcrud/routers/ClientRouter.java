package com.projects.webfluxcrud.routers;

import com.projects.webfluxcrud.handlers.ClientHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.*;

@Configuration
@EnableWebFlux
public class ClientRouter {

    @Bean
    public RouterFunction<ServerResponse> routes(ClientHandler clientHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/clients").or(RequestPredicates.GET("/clients/")), clientHandler::getAllClients)
                .andRoute(RequestPredicates.GET("/clients/{id}"), clientHandler::getClientById)
                .andRoute(RequestPredicates.POST("/clients"), clientHandler::createClient)
                .andRoute(RequestPredicates.PUT("/clients"), clientHandler::updateClient);
    }
}
