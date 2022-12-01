package ru.ssau.volunteerapi.model.dto.response;

import lombok.Builder;

@Builder
public record TaskResponse(String title,
                           String description,
                           String wish) {
}
