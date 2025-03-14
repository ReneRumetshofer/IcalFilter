package dev.rumetshofer.icalfilter.core.ports.out;

import net.fortuna.ical4j.model.Calendar;

public interface ForFetchIcal {

    Calendar fetchIcal(String url);

}
