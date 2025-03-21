package dev.rumetshofer.icalfilter.calendar.core.ports.out;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.EventFilterData;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ForEventFilterRepository {

    List<EventFilterData> getAllForCalendar(UUID calendarUuid);
    Optional<EventFilterData> getByUuid(UUID calendarUuid, UUID eventFilterUuid);

}
