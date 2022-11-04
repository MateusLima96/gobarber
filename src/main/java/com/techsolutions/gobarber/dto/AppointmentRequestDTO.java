package com.techsolutions.gobarber.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
public class AppointmentRequestDTO {


    @JsonProperty(value = "provider")
    private UUID provider;
    @JsonProperty(value = "date")
    private LocalDateTime date;


}
