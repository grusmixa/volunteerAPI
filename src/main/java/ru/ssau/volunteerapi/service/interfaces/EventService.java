package ru.ssau.volunteerapi.service.interfaces;

import ru.ssau.volunteerapi.model.dto.request.EventRequest;
import ru.ssau.volunteerapi.model.dto.response.EventResponse;
import ru.ssau.volunteerapi.model.entitie.Event;

import java.util.List;
import java.util.UUID;

public interface EventService {
    EventResponse getEventById(Integer id);

    List<EventResponse> getAllEvents();

    EventResponse createEvent(EventRequest eventRequest);

    Void deleteEvent(Integer id);

    Event findEntityById(Integer eventId);
}
