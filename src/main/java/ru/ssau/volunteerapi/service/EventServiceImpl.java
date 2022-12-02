package ru.ssau.volunteerapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ssau.volunteerapi.model.dto.response.EventResponse;
import ru.ssau.volunteerapi.service.interfaces.EventService;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventServiceImpl implements EventService {
    @Override
    public EventResponse getEventById(Integer id) {
        return null;
    }
}
