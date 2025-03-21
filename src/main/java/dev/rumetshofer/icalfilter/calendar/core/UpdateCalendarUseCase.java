package dev.rumetshofer.icalfilter.calendar.core;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.CalendarData;
import dev.rumetshofer.icalfilter.calendar.core.ports.in.ForUpdateCalendar;
import dev.rumetshofer.icalfilter.calendar.core.ports.out.ForCalendarRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateCalendarUseCase implements ForUpdateCalendar {

    private final ForCalendarRepository forCalendarRepository;

    public UpdateCalendarUseCase(ForCalendarRepository forCalendarRepository) {
        this.forCalendarRepository = forCalendarRepository;
    }

    @Override
    public void updateCalendar(UUID calendarUuid, String externalUrl) {
        forCalendarRepository.updateCalendar(
                CalendarData.builder()
                    .uuid(calendarUuid)
                    .externalUrl(externalUrl)
                    .build()
        );
    }

}
