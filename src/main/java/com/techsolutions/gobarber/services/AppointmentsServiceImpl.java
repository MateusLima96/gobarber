package com.techsolutions.gobarber.services;

import com.techsolutions.gobarber.dto.AppointmentRequestDTO;
import com.techsolutions.gobarber.dto.AppointmentResponseDTO;
import com.techsolutions.gobarber.models.Appointment;
import com.techsolutions.gobarber.repository.AppointmentsRepository;
import com.techsolutions.gobarber.utils.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.beans.Transient;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentsServiceImpl implements AppointmentService{

    private final AppointmentsRepository appointmentsRepository;


    @Override
    public Mono<AppointmentResponseDTO> createAppointment(final AppointmentRequestDTO appointmentRequestDTO){

        return this.appointmentsRepository
                .findByDate(EntityDtoUtil.toEntity(appointmentRequestDTO)
                            .getDate()
                )
                .flatMap(a -> Mono.<AppointmentResponseDTO>error(new Error("The appointment is already booked")))
                .switchIfEmpty(Mono.just(
                        EntityDtoUtil.toEntity(appointmentRequestDTO)
                ).flatMap(this.appointmentsRepository::save)
                        .map(ap -> EntityDtoUtil.toDto(appointmentRequestDTO, ap.getId())));
    }

    @Override
    public Flux<AppointmentResponseDTO> getAppointments() {
        return this.appointmentsRepository.findAll()
                .map(EntityDtoUtil::toDto);
    }
}
