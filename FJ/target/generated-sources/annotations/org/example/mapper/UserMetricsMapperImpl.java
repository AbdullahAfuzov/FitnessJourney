package org.example.mapper;

import javax.annotation.processing.Generated;
import org.example.dto.UserMetricsModelDTO;
import org.example.models.entities.UserMetricsModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T22:17:46+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMetricsMapperImpl implements UserMetricsMapper {

    @Override
    public UserMetricsModelDTO userMetricsToUserMetricsDTO(UserMetricsModel userMetricsModel) {
        if ( userMetricsModel == null ) {
            return null;
        }

        int id = 0;
        float kilograms = 0.0f;
        float centimeters = 0.0f;
        int age = 0;
        String gender = null;
        double caloriesBM = 0.0d;

        if ( userMetricsModel.getId() != null ) {
            id = userMetricsModel.getId();
        }
        kilograms = userMetricsModel.getKilograms();
        centimeters = userMetricsModel.getCentimeters();
        age = userMetricsModel.getAge();
        gender = userMetricsModel.getGender();
        caloriesBM = userMetricsModel.getCaloriesBM();

        UserMetricsModelDTO userMetricsModelDTO = new UserMetricsModelDTO( id, kilograms, centimeters, age, gender, caloriesBM );

        return userMetricsModelDTO;
    }
}
