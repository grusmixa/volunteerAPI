package ru.ssau.volunteerapi.service.interfaces;

import ru.ssau.volunteerapi.model.dto.response.ApplicationResponse;

import java.util.List;

public interface ApplicationService {
    List<ApplicationResponse> getAllApplications();

    ApplicationResponse getApplicationById(Integer id);

    ApplicationResponse applyToEvent(Integer eventId);

    List<ApplicationResponse> getApplicationsByEventId(Integer id);
}
