package ru.ssau.volunteerapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ssau.volunteerapi.model.dto.request.EventRequest;
import ru.ssau.volunteerapi.model.dto.response.ApplicationResponse;
import ru.ssau.volunteerapi.model.dto.response.EventResponse;
import ru.ssau.volunteerapi.model.dto.response.UserResponse;
import ru.ssau.volunteerapi.model.entitie.ApplicationStatus;
import ru.ssau.volunteerapi.service.interfaces.ApplicationService;
import ru.ssau.volunteerapi.service.interfaces.EventService;
import ru.ssau.volunteerapi.service.interfaces.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final EventService eventService;

    private final UserService userService;
    private final ApplicationService applicationService;

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
        return ResponseEntity.ok(applicationService.changeUserStatusInApplication(id, userId,status));
    }
}
