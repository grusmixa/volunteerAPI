package ru.ssau.volunteerapi.model.dto.response;

import lombok.Builder;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Builder
public record EventResponse(String title,
                            String description,
                            Integer volunteersAmount,
                            List<TaskResponse> tasks,
                            Date startedDay,
                            Date endedDay,
                            Time startedTime) {
}
