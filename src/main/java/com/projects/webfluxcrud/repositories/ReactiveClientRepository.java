package com.projects.webfluxcrud.repositories;

import com.projects.webfluxcrud.models.ClientModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReactiveClientRepository extends ReactiveMongoRepository<ClientModel, String> {

}
