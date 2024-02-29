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
public class FoodModelDTO {

    @NotNull(message = "Food name cannot be null")
    @NotBlank(message = "Food name cannot be empty")
    @Size(max = 20, message = "Name is too long")
    private String foodName;

    @NotNull(message = "Grams cannot be null")
    private float grams;

    @NotNull(message = "Food calories cannot be null")
    private float calories;
}
