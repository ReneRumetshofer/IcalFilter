package dev.rumetshofer.icalfilter.calendar.out.persistence.repositories;

import dev.rumetshofer.icalfilter.calendar.out.persistence.entities.EventFilterDbModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EventFilterDbModelRepository extends JpaRepository<EventFilterDbModel, UUID> {

    List<EventFilterDbModel> getAllByCalendar_Uuid(UUID calendarUuid);

}
