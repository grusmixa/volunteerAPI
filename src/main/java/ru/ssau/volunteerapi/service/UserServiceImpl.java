package ru.ssau.volunteerapi.service;

import ru.ssau.volunteerapi.model.dto.patch.UserPatch;
import ru.ssau.volunteerapi.model.dto.request.UserRequest;
import ru.ssau.volunteerapi.model.dto.response.LoginResponse;
import ru.ssau.volunteerapi.model.dto.response.UserResponse;
import ru.ssau.volunteerapi.service.interfaces.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Override
    public UserResponse findUserByUUID(UUID uuid) {
        return null;
    }

    @Override
    public LoginResponse register(UserRequest userRequest) {
        return null;
    }

    @Override
    public UserResponse patchUser(UserPatch userPatch) {
        return null;
    }
}
