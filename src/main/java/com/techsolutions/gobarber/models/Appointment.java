package com.techsolutions.gobarber.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@EntityScan("appointments")
public class Appointment {

    @Id
    private String id;

    @Column
    private String provider;

    @Column
    private Date date;

}
