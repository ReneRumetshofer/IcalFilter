package dev.rumetshofer.icalfilter.core.ports.out;

import dev.rumetshofer.icalfilter.core.domain.datacarrier.CalendarData;

import java.util.Optional;
import java.util.UUID;

public interface ForGetCalendar {

    Optional<CalendarData> getCalendarByUuid(UUID uuid);

}
