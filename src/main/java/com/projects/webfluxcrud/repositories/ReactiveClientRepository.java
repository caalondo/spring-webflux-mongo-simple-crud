package com.projects.webfluxcrud.repositories;

import com.projects.webfluxcrud.models.ClientModel;
import org.reactivestreams.Publisher;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ReactiveClientRepository implements ReactiveCrudRepository<ClientModel, String> {
    @Override
    public <S extends ClientModel> Mono<S> save(S entity) {
        return null;
    }

    @Override
    public <S extends ClientModel> Flux<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends ClientModel> Flux<S> saveAll(Publisher<S> entityStream) {
        return null;
    }

    @Override
    public Mono<ClientModel> findById(String s) {
        return null;
    }

    @Override
    public Mono<ClientModel> findById(Publisher<String> id) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(String s) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(Publisher<String> id) {
        return null;
    }

    @Override
    public Flux<ClientModel> findAll() {
        return null;
    }

    @Override
    public Flux<ClientModel> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public Flux<ClientModel> findAllById(Publisher<String> idStream) {
        return null;
    }

    @Override
    public Mono<Long> count() {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String s) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Publisher<String> id) {
        return null;
    }

    @Override
    public Mono<Void> delete(ClientModel entity) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends ClientModel> entities) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends ClientModel> entityStream) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }
}
