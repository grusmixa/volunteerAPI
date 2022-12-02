package ru.ssau.volunteerapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ssau.volunteerapi.model.dto.request.LoginRequest;
import ru.ssau.volunteerapi.model.dto.request.UserRequest;
import ru.ssau.volunteerapi.model.dto.response.LoginResponse;
import ru.ssau.volunteerapi.service.interfaces.UserService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @RequestMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @RequestMapping("/auth/logout")
    public ResponseEntity<LoginResponse> logout(@CookieValue(name = ACCESS_TOKEN) String tokenCookieValue) {
        return ResponseEntity.ok(userService.logout(tokenCookieValue));
    }

    @RequestMapping("/auth/register")
    public ResponseEntity<LoginResponse> register(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.register(userRequest));
    }
}
