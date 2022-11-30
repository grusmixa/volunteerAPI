package ru.ssau.volunteerapi.model.dto.response;

import ru.ssau.volunteerapi.model.entitie.ApplicationStatus;

public record ApplicationResponse(EventResponse event,
                                  ApplicationStatus status) {
}
