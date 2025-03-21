package dev.rumetshofer.icalfilter.calendar.core;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.EventFilterData;
import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.EventFilterType;
import net.fortuna.ical4j.model.component.VEvent;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class FilteringServiceTest {

    private FilteringService filteringService;

    private List<VEvent> events = List.of(
            new VEvent(LocalDate.of(2025, 12, 24), "SWEN2-"),
            new VEvent(LocalDate.of(2025, 12, 24), "EXAM-RECHT"),
            new VEvent(LocalDate.of(2025, 12, 24), "EXAM-REQUEN"),
            new VEvent(LocalDate.of(2025, 12, 24), "AKINF")
    );

    private List<EventFilterData> eventFilters = List.of(
            new EventFilterData(UUID.randomUUID(), UUID.randomUUID(), EventFilterType.STARTS_WITH, "SWEN2-"),
            new EventFilterData(UUID.randomUUID(), UUID.randomUUID(), EventFilterType.STARTS_WITH, "EXAM-RECHT")
    );

    @BeforeEach
    void setUp() {
        filteringService = new FilteringService();
    }

    @Test
    void getEventsToRemove_shouldApplyMultipleFilters() {
        List<VEvent> eventsToRemove = filteringService.getEventsToRemove(events, eventFilters);
        Assertions.assertThat(eventsToRemove)
                .hasSize(2)
                .anyMatch(event -> event.getSummary().getValue().equals("SWEN2-") || event.getSummary().getValue().equals("EXAM-RECHT"));
    }

}
