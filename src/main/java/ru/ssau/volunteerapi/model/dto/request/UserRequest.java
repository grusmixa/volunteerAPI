package ru.ssau.volunteerapi.model.dto.request;

import ru.ssau.volunteerapi.model.entitie.Sex;

public record UserRequest(String firstName,
                          String secondName,
                          String login,
                          String password,
                          String phone,
                          String email,
                          String experience,
                          String languages,
                          String education,
                          Sex sex) {
}
