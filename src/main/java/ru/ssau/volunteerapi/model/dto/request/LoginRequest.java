package ru.ssau.volunteerapi.model.dto.request;

public record LoginRequest(String email,
                           String password) {
}
