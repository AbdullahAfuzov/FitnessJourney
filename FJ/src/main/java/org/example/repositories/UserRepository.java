package org.example.repositories;

import org.example.models.entities.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {

    UserModel findUserModelByFirstName(String firstName);
}
