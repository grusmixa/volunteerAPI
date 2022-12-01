package ru.ssau.volunteerapi.model.dto.response;

import lombok.Builder;
import ru.ssau.volunteerapi.model.entitie.ApplicationStatus;

@Builder
public record ApplicationResponse(EventResponse event,
                                  UserResponse user,
                                  ApplicationStatus status) {
}
