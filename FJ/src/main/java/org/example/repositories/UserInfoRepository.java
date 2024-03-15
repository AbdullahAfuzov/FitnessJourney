package org.example.repositories;

import org.example.models.entities.UserInfoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfoModel, Integer> {

    UserInfoModel findByUsername(String userName);
}
