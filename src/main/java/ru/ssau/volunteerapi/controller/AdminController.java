package ru.ssau.volunteerapi.controller;

import lombok.RequiredArgsConstructor;
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
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminController {
    private final EventService eventService;
    private final UserService userService;
    private final ApplicationService applicationService;
    private final TaskService taskService;

    @GetMapping("/users/{user_id}")
    public ResponseEntity<UserResponse> findUserByUUID(@PathVariable("user_id") UUID userId) {
        return ResponseEntity.ok(userService.findUserByUUID(userId));
    }

    @PostMapping
    public ResponseEntity<EventResponse> createEvent(@RequestBody EventRequest eventRequest) {
        return ResponseEntity.ok(eventService.createEvent(eventRequest));
    }

    @DeleteMapping("/{event_id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("event_id") Integer id) {
        return ResponseEntity.ok(eventService.deleteEvent(id));
    }

    @GetMapping("/{event_id}/applications")
    public ResponseEntity<List<ApplicationResponse>> getApplicationsByEventId(@PathVariable("event_id") Integer id) {
        return ResponseEntity.ok(applicationService.getApplicationsByEventId(id));
    }

    @GetMapping("/{event_id}/applications/{user_id}")
    public ResponseEntity<Void> changeUserStatusInApplication(@PathVariable("event_id") Integer id,
                                                              @PathVariable("user_id") UUID userId,
                                                              @RequestBody ApplicationStatus status) {
        return ResponseEntity.ok(applicationService.changeUserStatusInApplication(id, userId, status));
    }

    @PostMapping("/createTask")
    public ResponseEntity<TaskGeneral> createTask(@RequestBody TaskGeneral taskGeneral) {
        return ResponseEntity.ok(taskService.createTask(taskGeneral));
    }
}
