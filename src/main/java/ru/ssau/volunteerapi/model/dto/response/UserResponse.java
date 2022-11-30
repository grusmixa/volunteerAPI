package ru.ssau.volunteerapi.model.dto.response;

import ru.ssau.volunteerapi.model.entitie.Sex;

import java.util.UUID;

public record UserResponse(UUID id,
                           String firstName,
                           String secondName,
                           Sex sex,
                           String experience,
                           String languages,
                           String education,
                           String phone) {
}
