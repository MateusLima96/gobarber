package com.techsolutions.gobarber.controllers;

import com.techsolutions.gobarber.dto.AppointmentRequestDTO;
import com.techsolutions.gobarber.dto.AppointmentResponseDTO;
import com.techsolutions.gobarber.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @GetMapping
    public Flux<AppointmentResponseDTO> getAppointments() {
            return appointmentService.getAppointments();
    }

}
