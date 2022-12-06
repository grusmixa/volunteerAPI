package ru.ssau.volunteerapi.controller;

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
@PreAuthorize("hasAnyAuthority('USER')")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/{task_id}")
    public ResponseEntity<TaskGeneral> getTaskById(@PathVariable("task_id") Integer id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping("/event/{event_id}")
    public ResponseEntity<List<TaskGeneral>> getTaskByEventId(@PathVariable("event_id") Integer id) {
        return ResponseEntity.ok(taskService.getTaskByEventId(id));
    }
}
