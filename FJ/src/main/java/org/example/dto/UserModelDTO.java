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

public class UserModelDTO {
    private int id;
    
    @NotNull(message = "User's first name cannot be empty!")
    @NotBlank(message = "User's first name cannot be empty!")
    @Size(max = 15, message = "User's first name cannot be longer than 15 characters!")
    private String firstName;

    @NotNull(message = "User's second name cannot be empty!")
    @NotBlank(message = "User's second name cannot be empty!")
    @Size(max = 15, message = "User's second name cannot be longer than 15 characters!")
    private String secondName;

    @NotNull(message = "User's last name cannot be empty!")
    @NotBlank(message = "User's last name cannot be empty!")
    @Size(max = 15, message = "User's last name cannot be longer than 15 characters!")
    private String lastName;

    @NotNull(message = "User's email cannot be empty!")
    @NotBlank(message = "User's email cannot be empty!")
    @Email(message = "User's email is not in a correct format!")
    @Size(max = 30, message = "User's email cannot be longer than 30 characters!")
    private String email;

    @NotNull(message = "User's phone number cannot be empty!")
    @NotBlank(message = "User's phone number cannot be empty!")
    @Size(max = 15, message = "User's phone number cannot be longer than 15 characters!")
    private String phoneNumber;

    @NotNull(message = "User's username cannot be empty!")
    @NotBlank(message = "User's username cannot be empty!")
    @Size(max = 15, message = "User's username cannot be longer than 15 characters!")
    private String username;

    @NotNull(message = "User's password cannot be empty!")
    @NotBlank(message = "User's password cannot be empty!")
    @Size(max = 20, message = "User's password cannot be longer than 20 characters!")
    private String password;
}
