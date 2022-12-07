package ru.ssau.volunteerapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.ssau.volunteerapi.exception.NotFoundException;
import ru.ssau.volunteerapi.model.dto.response.ApplicationResponse;
import ru.ssau.volunteerapi.model.entitie.Application;
import ru.ssau.volunteerapi.model.entitie.ApplicationStatus;
import ru.ssau.volunteerapi.model.entitie.Event;
import ru.ssau.volunteerapi.model.entitie.User;
import ru.ssau.volunteerapi.model.mapper.ApplicationMapper;
import ru.ssau.volunteerapi.repository.ApplicationRepository;
import ru.ssau.volunteerapi.repository.UserRepository;
import ru.ssau.volunteerapi.service.interfaces.ApplicationService;
import ru.ssau.volunteerapi.service.interfaces.EventService;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final ApplicationMapper applicationMapper;
    private final EventService eventService;

    @Override
    public List<ApplicationResponse> getAllApplications() {
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("User {} trying get all his applications.", userLogin);
        User user = userRepository.findByLogin(userLogin);
        List<Application> applications = applicationRepository.findByUserId(user);
        return applicationMapper.toResponses(applications);
    }

    @Override
    public ApplicationResponse getApplicationById(Integer id) {
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("User {} trying get application with id {}.", userLogin, id);
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Application with id " + id + " not found"));
        if (!Objects.equals(application.getUserId().getLogin(), userLogin)) {
            throw new AccessDeniedException("You can't watch this application");
        }
        return applicationMapper.toResponse(application);
    }

    @Override
    public ApplicationResponse applyToEvent(Integer eventId) {
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("User {} want apply to event with id {}.", userLogin, eventId);
        User user = userRepository.findByLogin(userLogin);
        Event event = eventService.findEntityById(eventId);
        Application application = Application.builder()
                .userId(user)
                .eventId(event)
                .status(ApplicationStatus.WAITED)
                .build();
        return applicationMapper.toResponse(applicationRepository.save(application));
    }

    @Override
    public List<ApplicationResponse> getApplicationsByEventId(Integer id) {
        String adminLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Admin {} trying get applications on event with id {}.", adminLogin, id);
        Event event = eventService.findEntityById(id);
        List<Application> applications = applicationRepository.findAllByEventId(event);
        System.out.println("d");
        return applicationMapper.toResponses(applicationRepository.findAllByEventId(event));
    }

    @Override
    public Void changeUserStatusInApplication(Integer eventId, UUID userId, ApplicationStatus status) {
        String adminLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Admin {} trying change user with id {} application status to {}.", adminLogin, userId, status);
        Application application = applicationRepository.findAllByEventId(eventService.findEntityById(eventId))
                .stream()
                .filter(application1 -> application1.getUserId().getId() == userId)
                .findAny()
                .orElseThrow(() -> new NotFoundException("User with id " + userId + " dont have application to event" + eventId));
        application.setStatus(status);
        applicationRepository.save(application);
        return null;
    }
}
