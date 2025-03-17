package dev.rumetshofer.icalfilter.calendar.out.persistence.repositories;

import dev.rumetshofer.icalfilter.calendar.out.persistence.entities.CalendarDbModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CalendarDbModelRepository extends JpaRepository<CalendarDbModel, UUID> {
}
