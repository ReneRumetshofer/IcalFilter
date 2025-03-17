package dev.rumetshofer.icalfilter.calendar.out.persistence;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.CalendarData;
import dev.rumetshofer.icalfilter.calendar.core.ports.out.ForGetCalendar;
import dev.rumetshofer.icalfilter.calendar.out.persistence.entities.CalendarDbModel;
import dev.rumetshofer.icalfilter.calendar.out.persistence.repositories.CalendarDbModelRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CalendarRepositoryAdapter implements ForGetCalendar {

    private final CalendarDbModelRepository calendarDbModelRepository;

    public CalendarRepositoryAdapter(CalendarDbModelRepository calendarDbModelRepository) {
        this.calendarDbModelRepository = calendarDbModelRepository;
    }

    @Override
    public Optional<CalendarData> getCalendarByUuid(UUID uuid) {
        return calendarDbModelRepository.findById(uuid)
                .map(this::toCalendarData);
    }

    private CalendarData toCalendarData(CalendarDbModel calendarDbModel) {
        return CalendarData.builder()
                .externalUrl(calendarDbModel.getExternalUrl())
                .uuid(calendarDbModel.getUuid())
                .build();
    }
}
