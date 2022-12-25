package ru.ssau.volunteerapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.ssau.volunteerapi.model.dto.patch.UserPatch;
import ru.ssau.volunteerapi.model.dto.response.UserResponse;
import ru.ssau.volunteerapi.service.interfaces.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Пользователи")
@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
public class UserController {
    private final UserService userService;

    @PatchMapping
    @Operation(summary = "Обновляет пользователя")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserPatch userPatch) {
        return ResponseEntity.ok(userService.patchUser(userPatch));
    }

    @GetMapping(produces = "application/json; charset=UTF-8")
    @Operation(summary = "Возвращает пользователя")
    public ResponseEntity<UserResponse> returnUser() {
        return ResponseEntity.ok(userService.returnUser());
    }
}
