package ru.ssau.volunteerapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ssau.volunteerapi.model.dto.general.TaskGeneral;
import ru.ssau.volunteerapi.service.interfaces.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/createTask")
    public ResponseEntity<TaskGeneral> createTask(@RequestBody TaskGeneral taskGeneral) {
        return ResponseEntity.ok(taskService.createTask(taskGeneral));
    }

    @GetMapping("/{task_id}")
    public ResponseEntity<TaskGeneral> getTaskById(@PathVariable("task_id") Integer id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping
    public ResponseEntity<List<TaskGeneral>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }
}
