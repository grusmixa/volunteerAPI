package ru.ssau.volunteerapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ssau.volunteerapi.model.dto.response.ApplicationResponse;
import ru.ssau.volunteerapi.service.interfaces.ApplicationService;

import java.util.List;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
public class ApplicationController {
    private final ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<List<ApplicationResponse>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @GetMapping("/{application_id}")
    public ResponseEntity<ApplicationResponse> getApplicationById(@PathVariable("application_id") Integer id) {
        return ResponseEntity.ok(applicationService.getApplicationById(id));
    }

    @GetMapping("/apply/{event_id}")
    public ResponseEntity<ApplicationResponse> applyToEvent(@PathVariable("event_id") Integer id) {
        return ResponseEntity.ok(applicationService.applyToEvent(id));
    }
}
