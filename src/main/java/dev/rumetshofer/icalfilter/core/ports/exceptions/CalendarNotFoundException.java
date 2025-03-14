package dev.rumetshofer.icalfilter.core.ports.exceptions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CalendarNotFoundException extends RuntimeException{

    private final UUID calendarUuid;

    public CalendarNotFoundException(UUID calendarUuid) {
        super("Calendar with UUID " + calendarUuid + " not found");
        this.calendarUuid = calendarUuid;
    }

}
