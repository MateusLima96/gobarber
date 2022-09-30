package com.techsolutions.gobarber.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Getter
@Setter
public class AppointmentRequestDTO {


    @JsonProperty
    private String provider;
    @JsonProperty
    private LocalDateTime date;


}
