package com.techsolutions.gobarber.repository;

import com.techsolutions.gobarber.models.Appointment;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

public interface AppointmentsRepository extends ReactiveCrudRepository<Appointment, UUID> {
    @Query("SELECT date FROM appointments WHERE date <> :date")
    Mono<Boolean> findByDate(LocalDateTime date);

}
