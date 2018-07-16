package com.projects.webfluxcrud.handlers;

import com.projects.webfluxcrud.models.ClientModel;
import com.projects.webfluxcrud.repositories.ReactiveClientRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ClientHandler {

    private final ReactiveClientRepository reactiveCrudRepository;

    public ClientHandler (ReactiveClientRepository reactiveCrudRepository) {
        this.reactiveCrudRepository = reactiveCrudRepository;
    }

    public Mono<ServerResponse> getAllClients(ServerRequest request) {
        Flux<ClientModel> clients = this.reactiveCrudRepository.findAll();
        System.out.println(clients);
//        return ServerResponse.ok().body(clients, ClientModel.class);
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Getting all clients..."));
    }

    public Mono<ServerResponse> getClientById(ServerRequest request) {

        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Getting client by id..."));
    }
}
