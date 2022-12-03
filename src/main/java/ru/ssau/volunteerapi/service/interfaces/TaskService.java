package ru.ssau.volunteerapi.service.interfaces;

import ru.ssau.volunteerapi.model.dto.general.TaskGeneral;

import java.util.List;

public interface TaskService {
    TaskGeneral createTask(TaskGeneral taskGeneral);

    TaskGeneral getTaskById(Integer id);

    List<TaskGeneral> getTaskByEventId(Integer id);

}
