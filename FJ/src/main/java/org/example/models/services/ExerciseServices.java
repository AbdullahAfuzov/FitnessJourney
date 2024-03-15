package org.example.models.services;

import lombok.AllArgsConstructor;
import org.example.dto.ExerciseModelDTO;
import org.example.mapper.ExerciseMapper;
import org.example.models.entities.ExerciseModel;
import org.example.repositories.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExerciseServices {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    public List<ExerciseModelDTO> getExercises(){
        List<ExerciseModelDTO> exerciseModelDTOS = new ArrayList<>();
        for (ExerciseModel exerciseModel : exerciseRepository.findAll()) {
            exerciseModelDTOS.add(exerciseMapper.exerciseToExDTO(exerciseModel));
        }

        return exerciseModelDTOS;
    }
    public ExerciseModelDTO getExercise(String exerciseName){
       ExerciseModel exerciseModel = exerciseRepository.findExerciseModelByExerciseName(exerciseName);
       if(exerciseModel == null) {
           throw new IllegalArgumentException();
       }
       return exerciseMapper.exerciseToExDTO(exerciseModel);
    }

    public ExerciseModelDTO addNewExercise(ExerciseModelDTO exerciseModelDTO) {
        ExerciseModel exerciseModel = new ExerciseModel(
                exerciseModelDTO.getExerciseName(),
                exerciseModelDTO.getRep(),
                exerciseModelDTO.getCaloriesBurned()
        );

        return exerciseMapper.exerciseToExDTO(exerciseRepository.save(exerciseModel));
    }

    public ExerciseModelDTO updateExercise(ExerciseModelDTO exerciseModelDTO) {
        ExerciseModel exerciseModel = new ExerciseModel(
                exerciseModelDTO.getExerciseName(),
                exerciseModelDTO.getRep(),
                exerciseModelDTO.getCaloriesBurned()
        );
        return exerciseMapper.exerciseToExDTO(exerciseRepository.save(exerciseModel));
    }

    public void deleteExercise(int id) {

        exerciseRepository.deleteById(id);
    }
}
