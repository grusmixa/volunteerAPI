package ru.ssau.volunteerapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ssau.volunteerapi.model.dto.general.TaskGeneral;
import ru.ssau.volunteerapi.service.interfaces.TaskService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {
    @Override
    public TaskGeneral createTask(TaskGeneral taskGeneral) {
        return null;
    }

    @Override
    public TaskGeneral getTaskById(Integer id) {
        return null;
    }

    @Override
    public List<TaskGeneral> getAllTasks() {
        return null;
    }
}
