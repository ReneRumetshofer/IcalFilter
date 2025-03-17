package dev.rumetshofer.icalfilter.calendar.out.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "calendar")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CalendarDbModel {

    @Id
    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @Column(name = "external_url", nullable = false, length = Integer.MAX_VALUE)
    private String externalUrl;

}
