package ru.ssau.volunteerapi.model.dto.request;

import org.hibernate.validator.constraints.Length;
import ru.ssau.volunteerapi.model.entitie.Sex;

import javax.validation.constraints.NotBlank;

public record UserRequest(String firstName,
                          String secondName,
                          String login,
                          @Length(max = 10, message = "Длина не должна превышать 10 символов")
                          @NotBlank
                          String password,
                          String phone,
                          String email,
                          String experience,
                          String languages,
                          String education,
                          Sex sex) {
}
