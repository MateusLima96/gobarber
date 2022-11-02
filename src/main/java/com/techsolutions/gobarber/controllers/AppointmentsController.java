package com.techsolutions.gobarber.controllers;

import com.techsolutions.gobarber.dto.AppointmentRequestDTO;
import com.techsolutions.gobarber.dto.AppointmentResponseDTO;
import com.techsolutions.gobarber.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping(value = "v1/appointments")
@RequiredArgsConstructor
public class AppointmentsController {


    private final AppointmentService appointmentService;

    @PostMapping
    public Mono<AppointmentResponseDTO> createAppointment(@RequestBody Mono<AppointmentRequestDTO> appointmentRequestDto) {

        Mono<AppointmentResponseDTO> appointmentResponseDTOMono = appointmentRequestDto.flatMap(this.appointmentService::createAppointment);
        return appointmentResponseDTOMono
                .onErrorResume(e -> {
                    if(e.getMessage().contains("The appointment is already booked")){
                        return Mono.error(new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage()));
                    }
                    return Mono.error(RuntimeException::new);
                });
    }

}
