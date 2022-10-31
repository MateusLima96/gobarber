package com.techsolutions.gobarber.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
public class AppointmentRequestDTO {


    @JsonProperty(value = "provider")
    private String provider;
    @JsonProperty(value = "date")
    private LocalDateTime date;


}
