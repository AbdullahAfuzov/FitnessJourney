package org.example.mapper;

import javax.annotation.processing.Generated;
import org.example.dto.UsersExModelDTO;
import org.example.models.entities.UsersExModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T22:17:46+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UsersExMapperImpl implements UsersExMapper {

    @Override
    public UsersExModelDTO usersExToUsersExDTO(UsersExModel usersExModel) {
        if ( usersExModel == null ) {
            return null;
        }

        int id = 0;
        String userExerciseName = null;
        int rep = 0;
        int caloriesBurned = 0;

        if ( usersExModel.getId() != null ) {
            id = usersExModel.getId();
        }
        userExerciseName = usersExModel.getUserExerciseName();
        rep = usersExModel.getRep();
        caloriesBurned = (int) usersExModel.getCaloriesBurned();

        UsersExModelDTO usersExModelDTO = new UsersExModelDTO( id, userExerciseName, rep, caloriesBurned );

        return usersExModelDTO;
    }
}
