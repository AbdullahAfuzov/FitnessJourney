package org.example.mapper;

import javax.annotation.processing.Generated;
import org.example.dto.UserModelDTO;
import org.example.models.entities.UserModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-14T23:57:39+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserModelDTO mapperUser(UserModel user) {
        if ( user == null ) {
            return null;
        }

        UserModelDTO userModelDTO = new UserModelDTO();

        if ( user.getId() != null ) {
            userModelDTO.setId( user.getId() );
        }
        userModelDTO.setFirstName( user.getFirstName() );
        userModelDTO.setSecondName( user.getSecondName() );
        userModelDTO.setLastName( user.getLastName() );
        userModelDTO.setEmail( user.getEmail() );
        userModelDTO.setPhoneNumber( user.getPhoneNumber() );

        return userModelDTO;
    }

    @Override
    public UserModel mapperUser(UserModelDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userDTO.getId() );
        userModel.setFirstName( userDTO.getFirstName() );
        userModel.setSecondName( userDTO.getSecondName() );
        userModel.setLastName( userDTO.getLastName() );
        userModel.setEmail( userDTO.getEmail() );
        userModel.setPhoneNumber( userDTO.getPhoneNumber() );

        return userModel;
    }
}
