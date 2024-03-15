package org.example.mapper;

import org.example.dto.UserModelDTO;
import org.example.models.entities.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface UserMapper {
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "password", ignore = true)
    UserModelDTO mapperUser(UserModel user);

    @Mapping(target = "userInfoModel", ignore = true)
    UserModel mapperUser(UserModelDTO userDTO);
}
