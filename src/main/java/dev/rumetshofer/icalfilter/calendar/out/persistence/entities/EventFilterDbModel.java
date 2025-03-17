package dev.rumetshofer.icalfilter.calendar.out.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "event_filter")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class EventFilterDbModel {

    @Id
    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @Column(name = "filter_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventFilterTypeDbModel filterType;

    @Column(name = "filter_value", nullable = false, length = Integer.MAX_VALUE)
    private String filterValue;

    @ManyToOne
    @JoinColumn(name = "calendar_uuid", nullable = false)
    private CalendarDbModel calendar;

}
