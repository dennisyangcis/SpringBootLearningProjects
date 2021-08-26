package org.yangcis.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.yangcis.webflux.entity.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
