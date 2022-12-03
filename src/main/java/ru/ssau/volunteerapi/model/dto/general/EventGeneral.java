package ru.ssau.volunteerapi.model.dto.general;

import lombok.Builder;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Builder
public record EventGeneral(Integer id,
                           String title,
                           String description,
                           Integer volunteersAmount,
                           List<TaskGeneral> tasks,
                           Date startedDay,
                           Date endedDay,
                           Time startedTime) {
}
