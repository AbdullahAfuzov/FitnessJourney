package org.example.repositories;

import org.example.models.entities.CoachModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends CrudRepository<CoachModel, Integer> {

    CoachModel findCoachModelByFirstName(String firstName);
}
