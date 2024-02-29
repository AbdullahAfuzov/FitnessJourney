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
public class UserMetricsModelDTO {
    private int id;

    @NotNull(message = "Kilograms cannot be null")
    private float kilograms;

    @NotNull(message = "Centimeters cannot be null")
    private float centimeters;

    @NotNull(message = "Age cannot be null")
    private int age;

    @NotNull(message = "Gender cannot be null")
    @NotBlank(message = "Gender cannot be empty")
    @Size(max = 1, message = "Valid gender can be M or F")
    private String gender;

    @NotNull(message = "BM calories cannot be null")
    private double caloriesBM;
}
