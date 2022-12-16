package ru.ssau.volunteerapi.service.interfaces;

import ru.ssau.volunteerapi.model.dto.response.ApplicationResponse;
import ru.ssau.volunteerapi.model.entitie.ApplicationStatus;

import java.util.List;
import java.util.UUID;

public interface ApplicationService {
    List<ApplicationResponse> getAllApplications();

    ApplicationResponse getApplicationById(Integer id);

    ApplicationResponse applyToEvent(Integer eventId);

    List<ApplicationResponse> getApplicationsByEventId(Integer id);

    Void changeUserStatusInApplication(Integer id, UUID userId, ApplicationStatus status);

    Void deleteApplication(Integer id);
}
