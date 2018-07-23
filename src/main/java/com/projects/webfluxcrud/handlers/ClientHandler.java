package com.projects.webfluxcrud.handlers;

import ch.qos.logback.core.net.server.Client;
import com.projects.webfluxcrud.models.ClientModel;
import com.projects.webfluxcrud.repositories.ReactiveClientRepository;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.swing.text.html.Option;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;


@RestController
public class ClientHandler {

    private ReactiveClientRepository reactiveClientRepository;

    public ClientHandler(ReactiveClientRepository reactiveClientRepository) {
        this.reactiveClientRepository = reactiveClientRepository;
    }

    public Mono<ServerResponse> getAllClients(ServerRequest request) {
        Flux<ClientModel> clients = this.reactiveClientRepository.findAll();

        JSONObject responseNotFound = new JSONObject();
        responseNotFound.put("status", HttpStatus.NOT_FOUND.value());
        responseNotFound.put("message", HttpStatus.NOT_FOUND);

        return clients
                .collectList()
                .flatMap(item ->
                        ServerResponse
                                .ok()
                                .body(BodyInserters.fromObject(item)))
                .switchIfEmpty(
                        ServerResponse
                                .status(HttpStatus.NOT_FOUND)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(Flux.just(responseNotFound.toString()), String.class))
                .onErrorResume(error ->
                        ServerResponse
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(Mono.just(error.toString()), String.class)
                );
    }

    public Mono<ServerResponse> getClientById(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<ClientModel> client = this.reactiveClientRepository.findById(id);

        JSONObject responseNotFound = new JSONObject();
        responseNotFound.put("status", HttpStatus.NOT_FOUND.value());
        responseNotFound.put("message", HttpStatus.NOT_FOUND);

        return client
                .flatMap(item ->
                        ServerResponse
                                .ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(Mono.just(item), ClientModel.class))
                .switchIfEmpty(
                        ServerResponse
                                .status(HttpStatus.NOT_FOUND)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(Mono.just(responseNotFound.toString()), String.class)
                )
                .onErrorResume(error ->
                        ServerResponse
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(Mono.just(error.toString()), String.class)
                );
    }

    public Mono<ServerResponse> createClient(ServerRequest request) {
        return request.bodyToMono(ClientModel.class)
                .flatMap(item -> this.reactiveClientRepository.save(item))
                .flatMap(item ->
                        ServerResponse
                                .status(HttpStatus.CREATED)
                                .body(Mono.just(item), ClientModel.class))
                .onErrorResume(error ->
                        ServerResponse
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(Mono.just(error.toString()), String.class)
                );
    }

    public Mono<ServerResponse> updateClient(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<ClientModel> clientFound = this.reactiveClientRepository.findById(id);
        MultiValueMap<String, String> clientUpdated = request.queryParams();

        return clientFound
                .flatMap(existingFound -> {
//                    this.reactiveClientRepository.save(clientUpdated);
                    return ServerResponse.ok().body(Mono.just(existingFound), ClientModel.class);
                });
    }
}
