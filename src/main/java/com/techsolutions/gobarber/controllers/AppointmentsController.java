package com.techsolutions.gobarber.controllers;

import com.techsolutions.gobarber.dto.AppointmentRequestDTO;
import com.techsolutions.gobarber.dto.AppointmentResponseDTO;
import com.techsolutions.gobarber.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/appointments")
@RequiredArgsConstructor
public class AppointmentsController {


    private final AppointmentService appointmentService;

    @PostMapping
    public Mono<AppointmentResponseDTO> createAppointment(@RequestBody Mono<AppointmentRequestDTO> appointmentRequestDto) {

        return appointmentRequestDto.flatMap(this.appointmentService::createAppointment);

    }

}
