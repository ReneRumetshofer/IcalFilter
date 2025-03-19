package dev.rumetshofer.icalfilter.calendar.in;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.CalendarData;
import dev.rumetshofer.icalfilter.calendar.core.ports.exceptions.CalendarNotFoundException;
import dev.rumetshofer.icalfilter.calendar.core.ports.in.ForGetCalendar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/calendars")
public class CalendarRestAdapter {

    private final ForGetCalendar forGetCalendar;

    public CalendarRestAdapter(ForGetCalendar forGetCalendar) {
        this.forGetCalendar = forGetCalendar;
    }

    @GetMapping
    public List<CalendarData> getAllCalendars() {
        return forGetCalendar.getAllCalendars();
    }

    @GetMapping("/{calendarUuid}")
    public CalendarData getCalendarById(@RequestParam("calendarUuid") UUID calendarUuid) {
        return forGetCalendar.getCalendarById(calendarUuid);
    }

}
