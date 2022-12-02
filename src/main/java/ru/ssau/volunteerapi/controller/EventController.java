package ru.ssau.volunteerapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ssau.volunteerapi.model.dto.general.EventGeneral;
import ru.ssau.volunteerapi.service.interfaces.EventService;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<EventGeneral>> getAllEvents(){
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/{event_id}")
    public ResponseEntity<EventGeneral> getEventById(@PathVariable("event_id") Integer id){
        return ResponseEntity.ok(eventService.getEventById(id));
    }
}
