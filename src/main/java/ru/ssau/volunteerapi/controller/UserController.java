package ru.ssau.volunteerapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ssau.volunteerapi.model.dto.patch.UserPatch;
import ru.ssau.volunteerapi.model.dto.response.UserResponse;
import ru.ssau.volunteerapi.service.interfaces.UserService;

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
}
