package com.techsolutions.gobarber.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Data
@Table("appointments")
@NoArgsConstructor
public class Appointment implements Persistable<UUID> {

    @Id
    private UUID id;

    private UUID provider_id;

    private LocalDateTime date;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    @Override
    public boolean isNew() {
        boolean result = Objects.isNull(id);
        this.id = result ? UUID.randomUUID() : this.id;
        return result;
    }
}