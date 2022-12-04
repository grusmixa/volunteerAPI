package ru.ssau.volunteerapi.model.dto.request;

import lombok.Builder;

import java.sql.Date;
import java.sql.Time;

@Builder
public record EventRequest(Integer id,
                           String title,
                           String description,
                           Integer volunteersAmount,
                           Date startedDay,
                           Date endedDay,
                           Time startedTime) {
}
