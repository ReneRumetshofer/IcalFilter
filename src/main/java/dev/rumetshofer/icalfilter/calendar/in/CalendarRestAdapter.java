package dev.rumetshofer.icalfilter.calendar.in;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.CalendarData;
import dev.rumetshofer.icalfilter.calendar.core.ports.in.ForCreateCalendar;
import dev.rumetshofer.icalfilter.calendar.core.ports.in.ForDeleteCalendar;
import dev.rumetshofer.icalfilter.calendar.core.ports.in.ForGetCalendar;
import dev.rumetshofer.icalfilter.calendar.core.ports.in.ForUpdateCalendar;
import dev.rumetshofer.icalfilter.calendar.in.requests.ChangeCalendarRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/calendars")
public class CalendarRestAdapter {

    private final ForGetCalendar forGetCalendar;
    private final ForCreateCalendar forCreateCalendar;
    private final ForUpdateCalendar forUpdateCalendar;
    private final ForDeleteCalendar forDeleteCalendar;

    public CalendarRestAdapter(ForGetCalendar forGetCalendar, ForCreateCalendar forCreateCalendar, ForUpdateCalendar forUpdateCalendar, ForDeleteCalendar forDeleteCalendar) {
        this.forGetCalendar = forGetCalendar;
        this.forCreateCalendar = forCreateCalendar;
        this.forUpdateCalendar = forUpdateCalendar;
        this.forDeleteCalendar = forDeleteCalendar;
    }

    @GetMapping
    public List<CalendarData> getAllCalendars() {
        return forGetCalendar.getAllCalendars();
    }

    @GetMapping("/{calendarUuid}")
    public CalendarData getCalendarById(@PathVariable("calendarUuid") UUID calendarUuid) {
        return forGetCalendar.getCalendarById(calendarUuid);
    }

    @PostMapping
    public void createCalendar(@RequestBody ChangeCalendarRequest request) {
        forCreateCalendar.createCalendar(request.externalUrl());
    }

    @PutMapping("/{calendarUuid}")
    public void updateCalendar(@PathVariable("calendarUuid") UUID calendarUuid, @RequestBody ChangeCalendarRequest request) {
        forUpdateCalendar.updateCalendar(calendarUuid, request.externalUrl());
    }

    @DeleteMapping("/{calendarUuid}")
    public void deleteCalendar(@PathVariable("calendarUuid") UUID calendarUuid) {
        forDeleteCalendar.deleteCalendar(calendarUuid);
    }

}
