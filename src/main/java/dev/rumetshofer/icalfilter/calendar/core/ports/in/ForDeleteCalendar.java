package dev.rumetshofer.icalfilter.calendar.core.ports.in;

import java.util.UUID;

public interface ForDeleteCalendar {

    void deleteCalendar(UUID calendarUuid);

}
