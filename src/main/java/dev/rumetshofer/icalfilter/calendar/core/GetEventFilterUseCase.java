package dev.rumetshofer.icalfilter.calendar.core;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.EventFilterData;
import dev.rumetshofer.icalfilter.calendar.core.ports.exceptions.CalendarNotFoundException;
import dev.rumetshofer.icalfilter.calendar.core.ports.in.ForGetEventFilter;
import dev.rumetshofer.icalfilter.calendar.core.ports.out.ForCalendarRepository;
import dev.rumetshofer.icalfilter.calendar.core.ports.out.ForEventFilterRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetEventFilterUseCase implements ForGetEventFilter {

    private final ForCalendarRepository forCalendarRepository;
    private final ForEventFilterRepository forEventFilterRepository;

    public GetEventFilterUseCase(ForCalendarRepository forCalendarRepository, ForEventFilterRepository forEventFilterRepository) {
        this.forCalendarRepository = forCalendarRepository;
        this.forEventFilterRepository = forEventFilterRepository;
    }

    @Override
    public List<EventFilterData> getAllForCalendar(UUID calendarUuid) {
        forCalendarRepository.getCalendarByUuid(calendarUuid)
                .orElseThrow(() -> new CalendarNotFoundException(calendarUuid));
        
        return forEventFilterRepository.getAllForCalendar(calendarUuid);
    }

    @Override
    public EventFilterData getByUuid(UUID calendarUuid, UUID eventFilterUuid) {
        forCalendarRepository.getCalendarByUuid(calendarUuid)
                .orElseThrow(() -> new CalendarNotFoundException(calendarUuid));

        return forEventFilterRepository.getByUuid(calendarUuid, eventFilterUuid)
                .orElseThrow(() -> new CalendarNotFoundException(calendarUuid));
    }

}
