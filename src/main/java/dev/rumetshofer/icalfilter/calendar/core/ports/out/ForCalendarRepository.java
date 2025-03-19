package dev.rumetshofer.icalfilter.calendar.core.ports.out;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.CalendarData;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ForCalendarRepository {

    Optional<CalendarData> getCalendarByUuid(UUID uuid);
    List<CalendarData> getAllCalendars();

}
