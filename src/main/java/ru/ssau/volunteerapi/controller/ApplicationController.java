package ru.ssau.volunteerapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Заявки")
@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
public class ApplicationController {
    private final ApplicationService applicationService;

    @GetMapping(produces = "application/json; charset=UTF-8")
    @Operation(summary = "Возвращает все мероприятия")
    public ResponseEntity<List<ApplicationResponse>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @GetMapping("/{application_id}")
    @Operation(summary = "Возвращает все заявку по id",description = "Только для админа")
    public ResponseEntity<ApplicationResponse> getApplicationById(@PathVariable("application_id") Integer id) {
        return ResponseEntity.ok(applicationService.getApplicationById(id));
    }

    @DeleteMapping("/{application_id}")
    @Operation(summary = "Удаляет заявку")
    public ResponseEntity<Void> deleteApplication(@PathVariable("application_id") Integer id) {
        return new ResponseEntity<>(applicationService.deleteApplication(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/apply/{event_id}")
    @Operation(summary = "Создает заявку на мероприятие")
    public ResponseEntity<ApplicationResponse> applyToEvent(@PathVariable("event_id") Integer id) {
        return ResponseEntity.ok(applicationService.applyToEvent(id));
    }
}
