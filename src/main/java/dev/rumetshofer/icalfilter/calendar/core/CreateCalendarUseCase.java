package dev.rumetshofer.icalfilter.calendar.core;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.CalendarData;
import dev.rumetshofer.icalfilter.calendar.core.ports.in.ForCreateCalendar;
import dev.rumetshofer.icalfilter.calendar.core.ports.out.ForCalendarRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateCalendarUseCase implements ForCreateCalendar {

    private final ForCalendarRepository forCalendarRepository;

    public CreateCalendarUseCase(ForCalendarRepository forCalendarRepository) {
        this.forCalendarRepository = forCalendarRepository;
    }

    @Override
    public void createCalendar(String externalUrl) {
        CalendarData calendarData = CalendarData.builder()
                .externalUrl(externalUrl)
                .uuid(UUID.randomUUID())
                .build();
        forCalendarRepository.createCalendar(calendarData);
    }
}
