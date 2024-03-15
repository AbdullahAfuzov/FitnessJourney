package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.ExerciseModelDTO;
import org.example.models.services.ExerciseServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ExerciseController {

    private final ExerciseServices exerciseServices;

    @GetMapping("/getExercises")
    public ResponseEntity<List<ExerciseModelDTO>> getExerciseController() {

        List<ExerciseModelDTO> exercises = exerciseServices.getExercises();

        return ResponseEntity.ok(exercises);
    }

    @GetMapping("/getExercise")
    public ResponseEntity<ExerciseModelDTO> getExercise(@RequestParam String name) {
        return ResponseEntity.ok(exerciseServices.getExercise(name));
    }

    @PostMapping("/addExercise")
    public ResponseEntity<ExerciseModelDTO> addNewExerciseController(@RequestBody ExerciseModelDTO exerciseModelDTO) {

        return ResponseEntity.ok(exerciseServices.addNewExercise(exerciseModelDTO));
    }

    @PutMapping("/updateExercise")
    public ResponseEntity<ExerciseModelDTO> updateExerciseController(@RequestBody ExerciseModelDTO exerciseModelDTO) {

        return ResponseEntity.ok(exerciseServices.updateExercise(exerciseModelDTO));
    }

    @DeleteMapping("/deleteExercise/{exNameDel}")
    public ResponseEntity<?> deleteExerciseController(@PathVariable int id) {

        exerciseServices.deleteExercise(id);
        return ResponseEntity.ok("DeleteOK");
    }
}
