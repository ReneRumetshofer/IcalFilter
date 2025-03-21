package dev.rumetshofer.icalfilter.calendar.in.requests;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.EventFilterType;
import lombok.Builder;

@Builder
public record ChangeEventFilterRequest(
        EventFilterType eventFilterType,
        String filterValue
) {
}
