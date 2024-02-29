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
public class UsersFoodModelDTO {

    private int id;

    @NotNull(message = "Food name cannot be null")
    @NotBlank(message = "Food name cannot be empty")
    @Size(max = 20, message = "Name is too long")
    private String usersFoodName;

    @NotNull(message = "Grams cannot be null")
    private float usersGrams;

    @NotNull(message = "Calories cannot be null")
    private float calories;
}
