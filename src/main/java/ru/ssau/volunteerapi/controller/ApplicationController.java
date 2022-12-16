package ru.ssau.volunteerapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.ssau.volunteerapi.model.dto.response.ApplicationResponse;
import ru.ssau.volunteerapi.service.interfaces.ApplicationService;

import java.util.List;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
public class ApplicationController {
    private final ApplicationService applicationService;

    @GetMapping(produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<ApplicationResponse>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @GetMapping("/{application_id}")
    public ResponseEntity<ApplicationResponse> getApplicationById(@PathVariable("application_id") Integer id) {
        return ResponseEntity.ok(applicationService.getApplicationById(id));
    }

    @DeleteMapping("/{application_id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable("application_id") Integer id) {
        return new ResponseEntity<>(applicationService.deleteApplication(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/apply/{event_id}")
    public ResponseEntity<ApplicationResponse> applyToEvent(@PathVariable("event_id") Integer id) {
        return ResponseEntity.ok(applicationService.applyToEvent(id));
    }
}
