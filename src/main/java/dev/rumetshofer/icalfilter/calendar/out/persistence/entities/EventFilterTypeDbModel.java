package dev.rumetshofer.icalfilter.calendar.out.persistence.entities;

import dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier.EventFilterType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventFilterTypeDbModel {
    STARTS_WITH(EventFilterType.STARTS_WITH)
    ;

    private final EventFilterType domainFilterType;
}
