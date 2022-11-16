package com.techsolutions.gobarber.utils;

import com.techsolutions.gobarber.dto.AppointmentRequestDTO;
import com.techsolutions.gobarber.dto.AppointmentResponseDTO;
import com.techsolutions.gobarber.dto.UserRequestDTO;
import com.techsolutions.gobarber.dto.UserResponseDTO;
import com.techsolutions.gobarber.models.Appointment;
import com.techsolutions.gobarber.models.User;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

public class EntityDtoUtil {


    public static Appointment toEntity(AppointmentRequestDTO appointmentRequestDTO){
            Appointment appointment = new Appointment();
            appointment.setDate(appointmentRequestDTO.getDate());
            appointment.setProvider_id(appointmentRequestDTO.getProvider_id());

            return appointment;
    }

    public static User toEntity(UserRequestDTO userRequestDTO, String password){
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(password);

        return user;
    }

    public static AppointmentResponseDTO toDto(Appointment appointment, UUID id){
        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();
        appointmentResponseDTO.setId(id);
        appointmentResponseDTO.setDate(appointment.getDate());
        appointmentResponseDTO.setProvider_id(appointment.getProvider_id());

        return appointmentResponseDTO;
    }



    public static AppointmentResponseDTO toDto(Appointment appointment){
        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();
        BeanUtils.copyProperties(appointment, appointmentResponseDTO);

        return appointmentResponseDTO;
    }

    public static UserResponseDTO toDto(User user, UUID id){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(id);
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());

        return userResponseDTO;
    }

    public static UserResponseDTO toDto(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        BeanUtils.copyProperties(user, userResponseDTO);

        return userResponseDTO;
    }




}
