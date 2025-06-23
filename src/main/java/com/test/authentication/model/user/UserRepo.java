package com.test.authentication.model.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
