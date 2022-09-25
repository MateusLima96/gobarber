package com.techsolutions.gobarber.services;

import com.techsolutions.gobarber.dto.AppointmentDTO;
import com.techsolutions.gobarber.repository.AppointmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AppointmentsService {

    private final AppointmentsRepository appointmentsRepository;

    @Transactional
    public Mono<AppointmentDTO> createAppointment(AppointmentDTO appointment){

        //TODO: create dtoToDomain

        //TODO: store date in a variable

        //TODO: create findByDateAppointment method in
        // order to see if the appointment has already been made

        //TODO: create domainToDto

       // appointmentsRepository.save(appointment);

          return null;
    }
}
