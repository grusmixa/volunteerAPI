package ru.ssau.volunteerapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ssau.volunteerapi.exception.NotFoundException;
import ru.ssau.volunteerapi.model.dto.patch.UserPatch;
import ru.ssau.volunteerapi.model.dto.request.LoginRequest;
import ru.ssau.volunteerapi.model.dto.request.UserRequest;
import ru.ssau.volunteerapi.model.dto.response.LoginResponse;
import ru.ssau.volunteerapi.model.dto.response.UserResponse;
import ru.ssau.volunteerapi.model.entitie.Role;
import ru.ssau.volunteerapi.model.entitie.User;
import ru.ssau.volunteerapi.model.mapper.UserMapper;
import ru.ssau.volunteerapi.repository.UserRepository;
import ru.ssau.volunteerapi.service.interfaces.UserService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse findUserByUUID(UUID uuid) {
        String adminLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Admin {} tried to find user with id {}.", adminLogin, uuid);
        User user = userRepository.findById(uuid)
                .orElseThrow(() -> new NotFoundException("User with id " + uuid + " not found!"));
        return userMapper.toResponse(user);
    }

    @Override
    public LoginResponse register(UserRequest userRequest) {
        log.info("Attempt register user with login {}.", userRequest.login());
        User user = userMapper.toEntity(userRequest);
        user.setId(UUID.randomUUID());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(userRequest.password()));
        userRepository.save(user);
        return new LoginResponse("", userRequest.firstName(), userRequest.secondName());
    }

    @Override
    public UserResponse patchUser(UserPatch userPatch) {
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("User {} trying update user info.", userLogin);
        User oldUser = userRepository.findByLogin(userLogin);
        User newUser = userMapper.toEntity(userPatch, oldUser);
        userRepository.save(newUser);
        return userMapper.toResponse(newUser);
    }

    @Override
    public LoginResponse logout(String tokenCookieValue) {
        return null;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        log.info("Login request for user {} account received", loginRequest.login());
        User foundUser = userRepository.findByLogin(loginRequest.login());
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.login(), loginRequest.password());
        authenticationManager.authenticate(authenticationToken);
        log.info("User {} successfully authenticated", loginRequest.login());
        return new LoginResponse("", foundUser.getFirstName(), foundUser.getSecondName());
    }
}
