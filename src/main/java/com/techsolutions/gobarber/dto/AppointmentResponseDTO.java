package com.techsolutions.gobarber.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class AppointmentResponseDTO {

    private UUID id;
    private UUID provider_id;
    private LocalDateTime date;

}
