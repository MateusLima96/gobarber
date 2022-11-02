package com.techsolutions.gobarber.services;

import com.techsolutions.gobarber.dto.AppointmentRequestDTO;
import com.techsolutions.gobarber.dto.AppointmentResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AppointmentService {
    Mono<AppointmentResponseDTO> createAppointment(AppointmentRequestDTO appointmentRequestDto);

    Flux<AppointmentResponseDTO> getAppointments();
}
