package ru.ssau.volunteerapi.model.dto.response;

import lombok.Builder;
import ru.ssau.volunteerapi.model.entitie.Sex;

import java.util.UUID;

@Builder
public record UserResponse(UUID id,
                           String firstName,
                           String secondName,
                           Sex sex,
                           String experience,
                           String languages,
                           String email,
                           String education,
                           String phone) {
}
