package dev.rumetshofer.icalfilter.calendar.core.ports.in;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.CalendarData;

import java.util.List;
import java.util.UUID;

public interface ForGetCalendar {

    List<CalendarData> getAllCalendars();
    CalendarData getCalendarById(UUID calendarUuid);

}
