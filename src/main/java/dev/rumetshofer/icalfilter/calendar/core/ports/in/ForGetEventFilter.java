package dev.rumetshofer.icalfilter.calendar.core.ports.in;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.EventFilterData;

import java.util.List;
import java.util.UUID;

public interface ForGetEventFilter {

    List<EventFilterData> getAllForCalendar(UUID calendarUuid);
    EventFilterData getByUuid(UUID calendarUuid, UUID eventFilterUuid);

}
