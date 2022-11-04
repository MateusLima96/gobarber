package com.techsolutions.gobarber.utils;

import com.techsolutions.gobarber.dto.AppointmentRequestDTO;
import com.techsolutions.gobarber.dto.AppointmentResponseDTO;
import com.techsolutions.gobarber.models.Appointment;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

public class EntityDtoUtil {


    public static Appointment toEntity(AppointmentRequestDTO appointmentRequestDTO){
            Appointment appointment = new Appointment();
            appointment.setDate(appointmentRequestDTO.getDate());
            appointment.setProvider_id(appointmentRequestDTO.getProvider());

            return appointment;
    }

    public static AppointmentResponseDTO toDto(AppointmentRequestDTO appointmentRequestDTO, UUID id){
        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();
        appointmentResponseDTO.setId(id);
        appointmentResponseDTO.setDate(appointmentRequestDTO.getDate());
        appointmentResponseDTO.setProvider(appointmentRequestDTO.getProvider());

        return appointmentResponseDTO;
    }

    public static AppointmentResponseDTO toDto(Appointment appointment){
        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();
        BeanUtils.copyProperties(appointment, appointmentResponseDTO);

        return appointmentResponseDTO;
    }


}
