package dev.rumetshofer.icalfilter.calendar.core.ports.out;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.EventFilterData;

import java.util.List;
import java.util.UUID;

public interface ForGetEventFilters {

    List<EventFilterData> getForCalendar(UUID calendarUuid);

}
