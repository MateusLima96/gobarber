package com.techsolutions.gobarber.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


@Table
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class Appointment {

    @Id
    private UUID id;

    private String provider;

    private LocalDateTime date;

}