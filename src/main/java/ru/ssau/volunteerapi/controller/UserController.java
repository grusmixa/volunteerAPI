package ru.ssau.volunteerapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ssau.volunteerapi.model.dto.patch.UserPatch;
import ru.ssau.volunteerapi.model.dto.response.UserResponse;
import ru.ssau.volunteerapi.service.interfaces.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{user_id}")
    public ResponseEntity<UserResponse> findUserByUUID(@PathVariable("user_id") UUID userId) {
        return ResponseEntity.ok(userService.findUserByUUID(userId));
    }

    @PatchMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserPatch userPatch) {
        return ResponseEntity.ok(userService.patchUser(userPatch));
    }
}
