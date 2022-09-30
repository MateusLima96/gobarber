package com.techsolutions.gobarber.services;

import com.techsolutions.gobarber.dto.AppointmentRequestDTO;
import com.techsolutions.gobarber.dto.AppointmentResponseDTO;
import com.techsolutions.gobarber.repository.AppointmentsRepository;
import com.techsolutions.gobarber.utils.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AppointmentsServiceImpl implements AppointmentService{

    private final AppointmentsRepository appointmentsRepository;


    @Override
    public Mono<AppointmentResponseDTO> createAppointment(final AppointmentRequestDTO appointmentRequestDTO){

        return this.appointmentsRepository
                .findByDate(appointmentRequestDTO.getDate())
                .filter(Boolean::booleanValue)
                .map(b -> EntityDtoUtil.toEntity(appointmentRequestDTO))
                .flatMap(this.appointmentsRepository::save)
                .map(ap -> EntityDtoUtil.toDto(appointmentRequestDTO))
                .switchIfEmpty(Mono.error( new Throwable("This appointment is already booked")));
    }
}
