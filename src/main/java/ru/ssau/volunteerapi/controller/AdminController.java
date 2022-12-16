package ru.ssau.volunteerapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.ssau.volunteerapi.model.dto.general.TaskGeneral;
import ru.ssau.volunteerapi.model.dto.request.EventRequest;
import ru.ssau.volunteerapi.model.dto.response.ApplicationResponse;
import ru.ssau.volunteerapi.model.dto.response.EventResponse;
import ru.ssau.volunteerapi.model.dto.response.UserResponse;
import ru.ssau.volunteerapi.model.entitie.ApplicationStatus;
import ru.ssau.volunteerapi.service.interfaces.ApplicationService;
import ru.ssau.volunteerapi.service.interfaces.EventService;
import ru.ssau.volunteerapi.service.interfaces.TaskService;
import ru.ssau.volunteerapi.service.interfaces.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Tag(name = "Админские функции")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminController {
    private final EventService eventService;
    private final UserService userService;
    private final ApplicationService applicationService;
    private final TaskService taskService;

    @GetMapping(value = "/users/{user_id}", produces = "application/json; charset=UTF-8")
    @Operation(summary = "Возвращает пользователя по его UUID")
    public ResponseEntity<UserResponse> findUserByUUID(@PathVariable("user_id") UUID userId) {
        return ResponseEntity.ok(userService.findUserByUUID(userId));
    }

    @PostMapping
    @Operation(summary = "Создает мероприятие")
    public ResponseEntity<EventResponse> createEvent(@RequestBody EventRequest eventRequest) {
        return new ResponseEntity<>(eventService.createEvent(eventRequest), HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json; charset=UTF-8")
    @Operation(summary = "Возвращает все мероприятия данного админа")
    public ResponseEntity<List<EventResponse>> getAllMyEvents() {
        return ResponseEntity.ok(eventService.getAllMyEvents());
    }

    @DeleteMapping("/{event_id}")
    @Operation(summary = "Удаляет мероприятие")
    public ResponseEntity<Void> deleteEvent(@PathVariable("event_id") Integer id) {
        return new ResponseEntity<>(eventService.deleteEvent(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/{event_id}/applications", produces = "application/json; charset=UTF-8")
    @Operation(summary = "Возвращает все заявки мероприятия")
    public ResponseEntity<List<ApplicationResponse>> getApplicationsByEventId(@PathVariable("event_id") Integer id) {
        return ResponseEntity.ok(applicationService.getApplicationsByEventId(id));
    }

    @PatchMapping("/{event_id}/applications/{user_id}")
    @Operation(summary = "Изменяет статус заявки")
    public ResponseEntity<Void> changeUserStatusInApplication(@PathVariable("event_id") Integer id,
                                                              @PathVariable("user_id") UUID userId,
                                                              @RequestParam ApplicationStatus status) {
        return ResponseEntity.ok(applicationService.changeUserStatusInApplication(id, userId, status));
    }

    @PostMapping("/createTask")
    @Operation(summary = "Создает задачу")
    public ResponseEntity<TaskGeneral> createTask(@RequestBody TaskGeneral taskGeneral) {
        return new ResponseEntity<>(taskService.createTask(taskGeneral), HttpStatus.CREATED);
    }
}
