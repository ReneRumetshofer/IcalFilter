package dev.rumetshofer.icalfilter.calendar.core.ports.in;

import java.io.IOException;
import java.util.UUID;

public interface ForFilterIcalSource {

    byte[] filter(UUID calendarUuid) throws IOException;

}
