package com.projects.webfluxcrud.handlers;

import com.projects.webfluxcrud.models.ClientModel;
import com.projects.webfluxcrud.repositories.ReactiveClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ClientHandler {

    @Autowired
    ReactiveClientRepository reactiveClientRepository;

    public Mono<ServerResponse> getAllClients(ServerRequest request) {
        Flux<ClientModel> clients = this.reactiveClientRepository.findAll();
        System.out.println(clients);
//        return ServerResponse.ok().body(clients, ClientModel.class);
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Getting all clients..."));
    }

    public Mono<ServerResponse> getClientById(ServerRequest request) {

        String id = request.pathVariable("id");
        System.out.println("\n=====> ID: " + id + "\n\n");

        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Getting client by id..."));
    }
}
