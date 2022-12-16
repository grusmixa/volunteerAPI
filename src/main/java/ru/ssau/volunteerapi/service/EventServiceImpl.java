package ru.ssau.volunteerapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ssau.volunteerapi.exception.NotFoundException;
import ru.ssau.volunteerapi.model.dto.general.TaskGeneral;
import ru.ssau.volunteerapi.model.dto.request.EventRequest;
import ru.ssau.volunteerapi.model.dto.response.EventResponse;
import ru.ssau.volunteerapi.model.entitie.Event;
import ru.ssau.volunteerapi.model.mapper.EventMapper;
import ru.ssau.volunteerapi.model.mapper.TaskMapper;
import ru.ssau.volunteerapi.repository.ApplicationRepository;
import ru.ssau.volunteerapi.repository.EventRepository;
import ru.ssau.volunteerapi.repository.TaskRepository;
import ru.ssau.volunteerapi.service.interfaces.EventService;
import ru.ssau.volunteerapi.service.interfaces.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;
    private final ApplicationRepository applicationRepository;
    private final UserService userService;

    @Override
    public EventResponse getEventById(Integer id) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("User with login {} tried to get event with id {}.", login, id);
        Event event = findEntityById(id);
        List<TaskGeneral> taskGenerals = taskMapper.toDtos(taskRepository.findByEventId(event));
        return eventMapper.toResponse(event, taskGenerals);
    }

    @Override
    public List<EventResponse> getAllEvents() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("User with login {} tried to get all events.", login);
        List<Event> events = eventRepository.findAll();
        return eventMapper.toResponses(events);
    }

    @Override
    public EventResponse createEvent(EventRequest eventRequest) {
        String admin = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Admin with login {} tried to create event.", admin);
        Event event = eventMapper.toEntity(eventRequest);
        event.setCreatorId(userService.findUserLogin(admin));
        return eventMapper.toResponse(eventRepository.save(event));
    }

    @Override
    @Transactional
    public Void deleteEvent(Integer id) {
        Event event = findEntityById(id);
        taskRepository.deleteAllByEventId(event);
        applicationRepository.deleteAllByEventId(event);
        eventRepository.delete(event);
        return null;
    }

    @Override
    public Event findEntityById(Integer eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new NotFoundException("Заявка с id: " + eventId + " не найдена"));
    }

    @Override
    public List<EventResponse> getAllMyEvents() {
        String admin = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Admin with login {} tried to get all him events.", admin);
        List<Event> events = eventRepository.findAllByCreatorId(userService.findUserLogin(admin));
        return eventMapper.toResponses(events);
    }
}
