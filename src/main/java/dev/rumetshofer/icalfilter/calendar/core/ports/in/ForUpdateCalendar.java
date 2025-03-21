package dev.rumetshofer.icalfilter.calendar.core.ports.in;

import java.util.UUID;

public interface ForUpdateCalendar {
    void updateCalendar(UUID calendarUuid, String externalUrl);
}
