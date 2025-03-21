package dev.rumetshofer.icalfilter.calendar.out.persistence;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.EventFilterData;
import dev.rumetshofer.icalfilter.calendar.core.ports.out.ForEventFilterRepository;
import dev.rumetshofer.icalfilter.calendar.out.persistence.entities.EventFilterDbModel;
import dev.rumetshofer.icalfilter.calendar.out.persistence.repositories.EventFilterDbModelRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class EventFilterRepositoryAdapter implements ForEventFilterRepository {

    private final EventFilterDbModelRepository eventFilterDbModelRepository;

    public EventFilterRepositoryAdapter(EventFilterDbModelRepository eventFilterDbModelRepository) {
        this.eventFilterDbModelRepository = eventFilterDbModelRepository;
    }

    @Override
    public List<EventFilterData> getAllForCalendar(UUID calendarUuid) {
        return eventFilterDbModelRepository.getAllByCalendar_Uuid(calendarUuid).stream()
                .map(this::toEventFilterData)
                .toList();
    }

    @Override
    public Optional<EventFilterData> getByUuid(UUID calendarUuid, UUID eventFilterUuid) {
        return eventFilterDbModelRepository.getByCalendar_UuidAndUuid(calendarUuid, eventFilterUuid)
                .map(this::toEventFilterData);
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
