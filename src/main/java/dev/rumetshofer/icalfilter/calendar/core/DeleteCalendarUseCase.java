package dev.rumetshofer.icalfilter.calendar.core;

import dev.rumetshofer.icalfilter.calendar.core.ports.in.ForDeleteCalendar;
import dev.rumetshofer.icalfilter.calendar.core.ports.out.ForCalendarRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteCalendarUseCase implements ForDeleteCalendar {

    private final ForCalendarRepository forCalendarRepository;

    public DeleteCalendarUseCase(ForCalendarRepository forCalendarRepository) {
        this.forCalendarRepository = forCalendarRepository;
    }

    @Override
    public void deleteCalendar(UUID calendarUuid) {
        forCalendarRepository.deleteCalendar(calendarUuid);
    }

}
