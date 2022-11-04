package com.techsolutions.gobarber.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class AppointmentResponseDTO {

    private UUID id;
    private UUID provider;
    private LocalDateTime date;


}
