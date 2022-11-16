package com.techsolutions.gobarber.repository;

import com.techsolutions.gobarber.models.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface UsersRepository extends ReactiveCrudRepository<User, UUID> {
    @Query("SELECT * FROM users WHERE email = :email")
    Mono<String> findByEmail(String email);
}
