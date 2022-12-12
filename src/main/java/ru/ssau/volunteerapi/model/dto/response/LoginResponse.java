package ru.ssau.volunteerapi.model.dto.response;

import lombok.Builder;
import ru.ssau.volunteerapi.model.entitie.Role;

@Builder
public record LoginResponse(String accessToken,String login, Role role) {
}
