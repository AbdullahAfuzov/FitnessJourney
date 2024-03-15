package org.example.mapper;

import javax.annotation.processing.Generated;
import org.example.dto.ExerciseModelDTO;
import org.example.models.entities.ExerciseModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-14T23:57:39+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ExerciseMapperImpl implements ExerciseMapper {

    @Override
    public ExerciseModelDTO exerciseToExDTO(ExerciseModel exerciseModel) {
        if ( exerciseModel == null ) {
            return null;
        }

        String exerciseName = null;
        int rep = 0;
        float caloriesBurned = 0.0f;

        exerciseName = exerciseModel.getExerciseName();
        rep = exerciseModel.getRep();
        caloriesBurned = exerciseModel.getCaloriesBurned();

        ExerciseModelDTO exerciseModelDTO = new ExerciseModelDTO( exerciseName, rep, caloriesBurned );

        return exerciseModelDTO;
    }
}
