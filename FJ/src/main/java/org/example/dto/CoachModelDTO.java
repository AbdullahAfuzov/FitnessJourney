package org.example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CoachModelDTO {
    private int id;

    @NotNull(message = "Coach's first name cannot be empty!")
    @NotBlank(message = "Coach's first name cannot be empty!")
    @Size(max = 15, message = "Coach's first name cannot be longer than 15 characters!")
    private String firstName;

    @NotNull(message = "Coach's second name cannot be empty!")
    @NotBlank(message = "Coach's second name cannot be empty!")
    @Size(max = 15, message = "Coach's second name cannot be longer than 15 characters!")
    private String secondName;

    @NotNull(message = "Coach's last name cannot be empty!")
    @NotBlank(message = "Coach's last name cannot be empty!")
    @Size(max = 15, message = "Coach's last name cannot be longer than 15 characters!")
    private String lastName;

    @NotNull(message = "Coach's email cannot be empty!")
    @NotBlank(message = "Coach's email cannot be empty!")
    @Email(message = "Coach's email is not in a correct format!")
    @Size(max = 30, message = "Coach's email cannot be longer than 30 characters!")
    private String email;

    @NotNull(message = "Coach's phone number cannot be empty!")
    @NotBlank(message = "Coach's phone number cannot be empty!")
    @Size(max = 15, message = "Coach's phone number cannot be longer than 15 characters!")
    private String phoneNumber;

    @NotNull(message = "Coach's username cannot be empty!")
    @NotBlank(message = "Coach's username cannot be empty!")
    @Size(max = 15, message = "Coach's username cannot be longer than 15 characters!")
    private String username;

    @NotNull(message = "Coach's password cannot be empty!")
    @NotBlank(message = "Coach's password cannot be empty!")
    @Size(max = 20, message = "Coach's password cannot be longer than 20 characters!")
    private String password;
}
