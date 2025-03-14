package dev.rumetshofer.icalfilter.core.domain.datacarrier;

import lombok.Builder;

import java.util.UUID;

@Builder
public record EventFilterData(
        UUID eventFilterUuid,
        UUID calendarUuid,
        EventFilterType eventFilterType,
        String filterValue
) {
}
