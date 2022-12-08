package ru.ssau.volunteerapi.model.dto.request;

import lombok.Builder;

import java.sql.Date;
import java.sql.Time;

@Builder
public record EventRequest(Integer id,
                           String title,
                           Integer volunteerAmount,
                           String place,
                           Date startedDay,
                           Date endedDay,
                           Time startedTime) {
}
