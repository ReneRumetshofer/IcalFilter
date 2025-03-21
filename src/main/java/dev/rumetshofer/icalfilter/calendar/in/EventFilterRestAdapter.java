package dev.rumetshofer.icalfilter.calendar.in;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.EventFilterData;
import dev.rumetshofer.icalfilter.calendar.core.ports.in.ForGetEventFilter;
import dev.rumetshofer.icalfilter.calendar.in.requests.ChangeEventFilterRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/calendars/{calendarUuid}/event-filters/")
public class EventFilterRestAdapter {

    private final ForGetEventFilter forGetEventFilter;

    public EventFilterRestAdapter(ForGetEventFilter forGetEventFilter) {
        this.forGetEventFilter = forGetEventFilter;
    }

    @GetMapping
    public List<EventFilterData> getAllEventFiltersForCalendar(@PathVariable("calendarUuid") UUID calendarUuid) {
        return forGetEventFilter.getAllForCalendar(calendarUuid);
    }

    @GetMapping("/{eventFilterUuid}")
    public EventFilterData getEventFilterForCalendar(
            @PathVariable("calendarUuid") UUID calendarUuid,
            @PathVariable("eventFilterUuid") UUID eventFilterUuid
    ) {
        return forGetEventFilter.getByUuid(calendarUuid, eventFilterUuid);
    }

    @PostMapping
    public void createEventFilterForCalendar(
            @PathVariable("calendarUuid") UUID calendarUuid,
            @RequestBody ChangeEventFilterRequest request
    ) {

    }

    @PutMapping("/{eventFilterUuid}")
    public void updateEventFilterForCalendar(
            @PathVariable("calendarUuid") UUID calendarUuid,
            @PathVariable("eventFilterUuid") UUID eventFilterUuid,
            @RequestBody ChangeEventFilterRequest request
    ) {

    }

    @DeleteMapping("/{eventFilterUuid}")
    public void deleteEventFilterForCalendar(
            @PathVariable("calendarUuid") UUID calendarUuid,
            @PathVariable("eventFilterUuid") UUID eventFilterUuid
    ) {
        
    }

}
