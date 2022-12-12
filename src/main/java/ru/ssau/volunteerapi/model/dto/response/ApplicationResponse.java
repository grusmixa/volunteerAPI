package ru.ssau.volunteerapi.model.dto.response;

import lombok.Builder;
import ru.ssau.volunteerapi.model.dto.request.EventRequest;
import ru.ssau.volunteerapi.model.entitie.ApplicationStatus;

@Builder
public record ApplicationResponse(Integer id,
                                  EventRequest event,
                                  UserResponse user,
                                  ApplicationStatus status) {
}
