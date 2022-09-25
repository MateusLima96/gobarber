package com.techsolutions.gobarber.repository;

import com.techsolutions.gobarber.models.Appointment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface AppointmentsRepository extends ReactiveCrudRepository<Appointment, UUID> {
    /*@Query("select id, firstname, lastname from customer c where c.lastname = :lastname")
    Flux<Customer> findByLastname(String lastname);*/
}
