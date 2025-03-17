package dev.rumetshofer.icalfilter.calendar.core.domain.datacarrier;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CalendarData(UUID uuid, String externalUrl) {
}
