package dev.rumetshofer.icalfilter.calendar.core.ports.out;

import net.fortuna.ical4j.model.Calendar;

public interface ForFetchIcal {

    Calendar fetchIcal(String url);

}
