package ru.ssau.volunteerapi.security.jwt;

import ru.ssau.volunteerapi.model.entitie.Role;

public record JwtUser(String login, Role role) {
}
