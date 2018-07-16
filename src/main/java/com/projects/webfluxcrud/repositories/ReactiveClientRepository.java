package com.projects.webfluxcrud.repositories;

import com.projects.webfluxcrud.models.ClientModel;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import reactor.core.publisher.Flux;

public interface ReactiveClientRepository extends CouchbaseRepository<ClientModel, Long> {

}
