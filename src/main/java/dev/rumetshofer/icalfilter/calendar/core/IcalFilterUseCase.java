package dev.rumetshofer.icalfilter.calendar.core;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.CalendarData;
import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.EventFilterData;
import dev.rumetshofer.icalfilter.calendar.core.ports.exceptions.CalendarNotFoundException;
import dev.rumetshofer.icalfilter.calendar.core.ports.in.ForFilterIcalSource;
import dev.rumetshofer.icalfilter.calendar.core.ports.out.ForFetchIcal;
import dev.rumetshofer.icalfilter.calendar.core.ports.out.ForCalendarRepository;
import dev.rumetshofer.icalfilter.calendar.core.ports.out.ForGetEventFilters;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.component.VEvent;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Component
public class IcalFilterUseCase implements ForFilterIcalSource {

    private final ForCalendarRepository forCalendarRepository;
    private final ForGetEventFilters forGetEventFilters;
    private final ForFetchIcal forFetchIcal;
    private final FilteringService filteringService;

    public IcalFilterUseCase(ForCalendarRepository forCalendarRepository, ForGetEventFilters forGetEventFilters, ForFetchIcal forFetchIcal, FilteringService filteringService) {
        this.forCalendarRepository = forCalendarRepository;
        this.forGetEventFilters = forGetEventFilters;
        this.forFetchIcal = forFetchIcal;
        this.filteringService = filteringService;
    }

    @Override
    public byte[] filter(UUID calendarUuid) throws IOException {
        CalendarData calendarData = forCalendarRepository.getCalendarByUuid(calendarUuid)
                .orElseThrow(() -> new CalendarNotFoundException(calendarUuid));

        Calendar calendar = forFetchIcal.fetchIcal(calendarData.externalUrl());
        List<EventFilterData> eventFilters = forGetEventFilters.getForCalendar(calendarUuid);
        List<VEvent> eventsToRemove = filteringService.getEventsToRemove(
                calendar.getComponents().stream().filter(component -> component instanceof VEvent).map(component -> (VEvent) component).toList(),
                eventFilters
        );
        eventsToRemove.forEach(calendar::remove);

        CalendarOutputter outputter = new CalendarOutputter();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputter.output(calendar, outputStream);
        return outputStream.toByteArray();
    }
}
