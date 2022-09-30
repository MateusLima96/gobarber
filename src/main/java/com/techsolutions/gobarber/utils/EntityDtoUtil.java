package com.techsolutions.gobarber.utils;

import com.techsolutions.gobarber.dto.AppointmentRequestDTO;
import com.techsolutions.gobarber.dto.AppointmentResponseDTO;
import com.techsolutions.gobarber.models.Appointment;

import java.time.LocalDateTime;

public class EntityDtoUtil {


    public static Appointment toEntity(AppointmentRequestDTO appointmentRequestDTO){
            Appointment appointment = new Appointment();
            appointment.setDate(LocalDateTime.now());
            appointment.setProvider(appointmentRequestDTO.getProvider());

            return appointment;
    }

    public static AppointmentResponseDTO toDto(AppointmentRequestDTO appointmentRequestDTO){
        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();
        appointmentResponseDTO.setDate(appointmentRequestDTO.getDate());
        appointmentResponseDTO.setProvider(appointmentRequestDTO.getProvider());

        return appointmentResponseDTO;
    }


}
