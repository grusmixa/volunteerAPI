package ru.ssau.volunteerapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ssau.volunteerapi.model.dto.response.ApplicationResponse;
import ru.ssau.volunteerapi.service.interfaces.ApplicationService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {
    @Override
    public List<ApplicationResponse> getAllApplications() {
        return null;
    }

    @Override
    public ApplicationResponse getApplicationById(Integer id) {
        return null;
    }

    @Override
    public ApplicationResponse applyToEvent(Integer eventId) {
        return null;
    }
}
