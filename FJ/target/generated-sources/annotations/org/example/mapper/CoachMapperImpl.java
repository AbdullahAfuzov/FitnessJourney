package org.example.mapper;

import javax.annotation.processing.Generated;
import org.example.dto.CoachModelDTO;
import org.example.models.entities.CoachModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-14T23:57:39+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CoachMapperImpl implements CoachMapper {

    @Override
    public CoachModelDTO coachMapper(CoachModel coach) {
        if ( coach == null ) {
            return null;
        }

        CoachModelDTO coachModelDTO = new CoachModelDTO();

        if ( coach.getId() != null ) {
            coachModelDTO.setId( coach.getId() );
        }
        coachModelDTO.setFirstName( coach.getFirstName() );
        coachModelDTO.setSecondName( coach.getSecondName() );
        coachModelDTO.setLastName( coach.getLastName() );
        coachModelDTO.setEmail( coach.getEmail() );
        coachModelDTO.setPhoneNumber( coach.getPhoneNumber() );

        return coachModelDTO;
    }

    @Override
    public CoachModel coachMapper(CoachModelDTO coachDTO) {
        if ( coachDTO == null ) {
            return null;
        }

        CoachModel coachModel = new CoachModel();

        coachModel.setId( coachDTO.getId() );
        coachModel.setFirstName( coachDTO.getFirstName() );
        coachModel.setSecondName( coachDTO.getSecondName() );
        coachModel.setLastName( coachDTO.getLastName() );
        coachModel.setEmail( coachDTO.getEmail() );
        coachModel.setPhoneNumber( coachDTO.getPhoneNumber() );

        return coachModel;
    }
}
