package ru.ssau.volunteerapi.model.dto.general;

import lombok.Builder;

@Builder
public record TaskGeneral(Integer id,
                          String title,
                          String description,
                          String wish) {
}
