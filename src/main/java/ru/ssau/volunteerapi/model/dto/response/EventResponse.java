package ru.ssau.volunteerapi.model.dto.response;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public record EventResponse(String title,
                            String description,
                            Integer volunteersAmount,
                            List<TaskResponse> tasks,
                            Date startedDay,
                            Date endedDay,
                            Time startedTime) {
}
