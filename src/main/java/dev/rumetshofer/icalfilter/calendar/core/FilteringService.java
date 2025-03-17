package dev.rumetshofer.icalfilter.calendar.core;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.EventFilterData;
import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.EventFilterType;
import net.fortuna.ical4j.model.component.VEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class FilteringService {

    List<VEvent> getEventsToRemove(List<VEvent> events, List<EventFilterData> eventFilters) {
        List<VEvent> eventsToRemove = events;
        for (EventFilterData eventFilter : eventFilters) {
            if (Objects.requireNonNull(eventFilter.eventFilterType()) == EventFilterType.STARTS_WITH) {
                eventsToRemove = eventsToRemove.stream()
                        .filter(event -> event.getSummary().getValue().startsWith(eventFilter.filterValue()))
                        .toList();
            }
            else {
                throw new IllegalStateException("Unknown filter type: " + eventFilter.eventFilterType());
            }
        }

        return eventsToRemove;
    }

}
