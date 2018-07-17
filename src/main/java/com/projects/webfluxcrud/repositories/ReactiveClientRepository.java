package com.projects.webfluxcrud.repositories;

import com.projects.webfluxcrud.models.ClientModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface ReactiveClientRepository extends ReactiveCrudRepository<ClientModel, String> {
    Flux<ClientModel> findByName(String name);
}
