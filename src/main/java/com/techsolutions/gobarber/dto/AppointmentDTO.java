package com.techsolutions.gobarber.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AppointmentDTO {

    private String id;
    private String provider;
    private Date date;

}
