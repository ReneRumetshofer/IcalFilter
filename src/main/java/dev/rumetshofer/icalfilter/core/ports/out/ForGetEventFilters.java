package dev.rumetshofer.icalfilter.core.ports.out;

import dev.rumetshofer.icalfilter.core.domain.datacarrier.EventFilterData;

import java.util.List;
import java.util.UUID;

public interface ForGetEventFilters {

    List<EventFilterData> getForCalendar(UUID calendarUuid);

}
