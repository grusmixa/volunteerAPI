package ru.ssau.volunteerapi.service.interfaces;

import ru.ssau.volunteerapi.model.dto.response.EventResponse;

public interface EventService {
    EventResponse getEventById(Integer id);
}
