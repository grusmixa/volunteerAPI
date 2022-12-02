package ru.ssau.volunteerapi.model.dto.response;

import lombok.Builder;
import ru.ssau.volunteerapi.model.dto.general.EventGeneral;
import ru.ssau.volunteerapi.model.entitie.ApplicationStatus;

@Builder
public record ApplicationResponse(Integer id,
                                  EventGeneral event,
                                  UserResponse user,
                                  ApplicationStatus status) {
}
