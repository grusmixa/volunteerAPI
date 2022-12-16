package ru.ssau.volunteerapi.model.dto.response;

import lombok.Builder;
import ru.ssau.volunteerapi.model.dto.general.TaskGeneral;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Builder
public record EventResponse(Integer id,
                           String title,
                           Integer volunteerAmount,
                           String place,
                           List<TaskGeneral> tasks,
                           Date startedDay,
                           Date endedDay,
                           Time startedTime) {
}
