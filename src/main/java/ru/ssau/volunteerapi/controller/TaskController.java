package ru.ssau.volunteerapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.ssau.volunteerapi.model.dto.general.TaskGeneral;
import ru.ssau.volunteerapi.service.interfaces.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
@Tag(name = "Задачи")
@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/{task_id}")
    @Operation(summary = "Возвращает задачу по id")
    public ResponseEntity<TaskGeneral> getTaskById(@PathVariable("task_id") Integer id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping("/event/{event_id}")
    @Operation(summary = "Возвращает все задачи мероприятия")
    public ResponseEntity<List<TaskGeneral>> getTaskByEventId(@PathVariable("event_id") Integer id) {
        return ResponseEntity.ok(taskService.getTaskByEventId(id));
    }
}
