package dev.rumetshofer.icalfilter.out.persistence;

import dev.rumetshofer.icalfilter.core.domain.datacarrier.EventFilterData;
import dev.rumetshofer.icalfilter.core.ports.out.ForGetEventFilters;
import dev.rumetshofer.icalfilter.out.persistence.entities.EventFilterDbModel;
import dev.rumetshofer.icalfilter.out.persistence.repositories.EventFilterDbModelRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EventFilterRepositoryAdapter implements ForGetEventFilters {

    private final EventFilterDbModelRepository eventFilterDbModelRepository;

    public EventFilterRepositoryAdapter(EventFilterDbModelRepository eventFilterDbModelRepository) {
        this.eventFilterDbModelRepository = eventFilterDbModelRepository;
    }

    @Override
    public List<EventFilterData> getForCalendar(UUID calendarUuid) {
        return eventFilterDbModelRepository.getAllByCalendar_Uuid(calendarUuid).stream()
                .map(this::toEventFilterData)
                .toList();
    }

    private EventFilterData toEventFilterData(EventFilterDbModel eventFilterDbModel) {
        return EventFilterData.builder()
                .eventFilterUuid(eventFilterDbModel.getUuid())
                .eventFilterType(eventFilterDbModel.getFilterType().getDomainFilterType())
                .filterValue(eventFilterDbModel.getFilterValue())
                .calendarUuid(eventFilterDbModel.getCalendar().getUuid())
                .build();
    }
}
