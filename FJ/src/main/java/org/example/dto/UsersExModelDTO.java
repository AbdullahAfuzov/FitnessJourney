package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UsersExModelDTO {

    private int id;

    @NotNull(message = "Exercise name cannot be null")
    @NotBlank(message = "Exercise name cannot be empty")
    @Size(max = 20, message = "Name is too long")
    private String userExerciseName;

    @NotNull(message = "Rep cannot be null")
    private int rep;

    @NotNull(message = "Burned calories cannot be null")
    private int caloriesBurned;
}
