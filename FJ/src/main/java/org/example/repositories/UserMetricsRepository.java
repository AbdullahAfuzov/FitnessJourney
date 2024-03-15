package org.example.repositories;

import org.example.models.entities.UserMetricsModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMetricsRepository extends CrudRepository<UserMetricsModel, Integer> {

    Page<UserMetricsModel> findUserMetricsModelsByGender(String gender, Pageable pageable);
}
