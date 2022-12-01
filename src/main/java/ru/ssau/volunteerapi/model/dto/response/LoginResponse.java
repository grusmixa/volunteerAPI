package ru.ssau.volunteerapi.model.dto.response;

import lombok.Builder;

@Builder
public record LoginResponse(String accessToken,String firstName,String lastName) {
}
