package ru.ssau.volunteerapi.service.interfaces;

import ru.ssau.volunteerapi.model.dto.patch.UserPatch;
import ru.ssau.volunteerapi.model.dto.request.LoginRequest;
import ru.ssau.volunteerapi.model.dto.request.UserRequest;
import ru.ssau.volunteerapi.model.dto.response.LoginResponse;
import ru.ssau.volunteerapi.model.dto.response.UserResponse;
import ru.ssau.volunteerapi.model.entitie.User;

import java.util.UUID;

public interface UserService {
    UserResponse findUserByUUID(UUID uuid);

    LoginResponse register(UserRequest userRequest);

    UserResponse patchUser(UserPatch userPatch);

    LoginResponse logout(String tokenCookieValue);

    LoginResponse login(LoginRequest loginRequest);

    User findUserLogin(String login);

    UserResponse returnUser();
}
