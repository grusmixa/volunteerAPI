package ru.ssau.volunteerapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ssau.volunteerapi.model.dto.general.EventGeneral;
import ru.ssau.volunteerapi.model.dto.response.ApplicationResponse;
import ru.ssau.volunteerapi.service.interfaces.EventService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventServiceImpl implements EventService {
    @Override
    public EventGeneral getEventById(Integer id) {
        return null;
    }

    @Override
    public List<EventGeneral> getAllEvents() {
        return null;
    }

    @Override
    public EventGeneral createEvent(EventGeneral eventGeneral) {
        return null;
    }

    @Override
    public Void deleteEvent(Integer id) {
        return null;
    }

    @Override
    public ApplicationResponse getApplicationsByEventId(Integer id) {
        return null;
    }

    @Override
    public Void changeUserStatusInApplication(Integer id, UUID userId) {
        return null;
    }
}
