package org.example.mapper;

import javax.annotation.processing.Generated;
import org.example.dto.UsersFoodModelDTO;
import org.example.models.entities.UsersFoodModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-14T23:57:39+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UsersFoodMapperImpl implements UsersFoodMapper {

    @Override
    public UsersFoodModelDTO usersFoodToUsersFoodDTO(UsersFoodModel usersFoodModel) {
        if ( usersFoodModel == null ) {
            return null;
        }

        int id = 0;
        String usersFoodName = null;
        float usersGrams = 0.0f;
        float calories = 0.0f;

        if ( usersFoodModel.getId() != null ) {
            id = usersFoodModel.getId();
        }
        usersFoodName = usersFoodModel.getUsersFoodName();
        usersGrams = usersFoodModel.getUsersGrams();
        calories = usersFoodModel.getCalories();

        UsersFoodModelDTO usersFoodModelDTO = new UsersFoodModelDTO( id, usersFoodName, usersGrams, calories );

        return usersFoodModelDTO;
    }
}
