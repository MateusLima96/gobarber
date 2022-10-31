package com.techsolutions.gobarber.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Getter
@Setter
public class AppointmentResponseDTO {

    private UUID id;
    private String provider;
    private LocalDateTime date;


}
