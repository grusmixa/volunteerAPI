package ru.ssau.volunteerapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.ssau.volunteerapi.model.dto.request.EventRequest;
import ru.ssau.volunteerapi.model.dto.response.EventResponse;
import ru.ssau.volunteerapi.service.interfaces.EventService;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('USER')")
public class EventController {
    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvents(){
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/{event_id}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable("event_id") Integer id){
        return ResponseEntity.ok(eventService.getEventById(id));
    }
}
