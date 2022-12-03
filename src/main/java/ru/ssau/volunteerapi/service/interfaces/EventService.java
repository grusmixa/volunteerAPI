package ru.ssau.volunteerapi.service.interfaces;

import ru.ssau.volunteerapi.model.dto.general.EventGeneral;
import ru.ssau.volunteerapi.model.dto.response.ApplicationResponse;
import ru.ssau.volunteerapi.model.entitie.Event;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventService {
    EventGeneral getEventById(Integer id);

    List<EventGeneral> getAllEvents();

    EventGeneral createEvent(EventGeneral eventGeneral);

    Void deleteEvent(Integer id);

    ApplicationResponse getApplicationsByEventId(Integer id);

    Void changeUserStatusInApplication(Integer id, UUID userId);

    Event findEntityById(Integer eventId);
}
