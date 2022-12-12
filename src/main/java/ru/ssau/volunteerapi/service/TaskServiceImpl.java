package ru.ssau.volunteerapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.ssau.volunteerapi.exception.NotFoundException;
import ru.ssau.volunteerapi.model.dto.general.TaskGeneral;
import ru.ssau.volunteerapi.model.entitie.Event;
import ru.ssau.volunteerapi.model.entitie.Task;
import ru.ssau.volunteerapi.model.mapper.TaskMapper;
import ru.ssau.volunteerapi.repository.TaskRepository;
import ru.ssau.volunteerapi.service.interfaces.EventService;
import ru.ssau.volunteerapi.service.interfaces.TaskService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final EventService eventService;

    @Override
    public TaskGeneral createTask(TaskGeneral taskGeneral) {
        String adminLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Admin {} trying create new task {}", adminLogin, taskGeneral.title());
        Event event = eventService.findEntityById(taskGeneral.eventId());
        Task task = taskMapper.toEntity(taskGeneral);
        task.setEventId(event);
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    @Override
    public TaskGeneral getTaskById(Integer id) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("User {} trying get task {}", login, id);
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Задача с id: " + id + " не найдена"));
        return taskMapper.toDto(task);
    }

    @Override
    public List<TaskGeneral> getTaskByEventId(Integer id) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("User {} trying get all tasks on event with id {}", login, id);
        Event event = eventService.findEntityById(id);
        return taskMapper.toDtos(taskRepository.findByEventId(event));
    }
}
