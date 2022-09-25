package com.techsolutions.gobarber.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class AppointmentDTO {

    @Id
    private UUID id;
    private String provider;
    private Date date;

}
