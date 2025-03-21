package dev.rumetshofer.icalfilter.calendar.core.ports.exceptions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class EventFilterNotFoundException extends RuntimeException{

    private final UUID eventFilterUuid;

    public EventFilterNotFoundException(UUID eventFilterUuid) {
        super("Event filter with UUID " + eventFilterUuid + " not found");
        this.eventFilterUuid = eventFilterUuid;
    }

}
