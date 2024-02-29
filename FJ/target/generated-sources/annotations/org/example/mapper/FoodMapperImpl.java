package org.example.mapper;

import javax.annotation.processing.Generated;
import org.example.dto.FoodModelDTO;
import org.example.models.entities.FoodModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T22:42:40+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class FoodMapperImpl implements FoodMapper {

    @Override
    public FoodModelDTO foodToFoodDTO(FoodModel foodModel) {
        if ( foodModel == null ) {
            return null;
        }

        String foodName = null;
        float grams = 0.0f;
        float calories = 0.0f;

        foodName = foodModel.getFoodName();
        grams = foodModel.getGrams();
        calories = foodModel.getCalories();

        FoodModelDTO foodModelDTO = new FoodModelDTO( foodName, grams, calories );

        return foodModelDTO;
    }
}
