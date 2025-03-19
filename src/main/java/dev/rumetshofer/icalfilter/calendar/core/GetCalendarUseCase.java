package dev.rumetshofer.icalfilter.calendar.core;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.CalendarData;
import dev.rumetshofer.icalfilter.calendar.core.ports.exceptions.CalendarNotFoundException;
import dev.rumetshofer.icalfilter.calendar.core.ports.in.ForGetCalendar;
import dev.rumetshofer.icalfilter.calendar.core.ports.out.ForCalendarRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetCalendarUseCase implements ForGetCalendar {

    private final ForCalendarRepository forCalendarRepository;

    public GetCalendarUseCase(ForCalendarRepository forCalendarRepository) {
        this.forCalendarRepository = forCalendarRepository;
    }

    @Override
    public List<CalendarData> getAllCalendars() {
        return forCalendarRepository.getAllCalendars();
    }

    @Override
    public CalendarData getCalendarById(UUID calendarUuid) {
        return forCalendarRepository.getCalendarByUuid(calendarUuid)
                .orElseThrow(() -> new CalendarNotFoundException(calendarUuid));
    }

}
