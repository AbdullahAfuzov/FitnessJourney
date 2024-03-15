package org.example.repositories;

import org.example.models.entities.ExerciseModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ExerciseRepository extends CrudRepository<ExerciseModel, Integer> {

    ExerciseModel findExerciseModelByExerciseName(String exNameDel);

}
