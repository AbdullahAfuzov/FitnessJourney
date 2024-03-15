package org.example.mapper;

import org.example.dto.CoachModelDTO;
import org.example.models.entities.CoachModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface CoachMapper {
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "password", ignore = true)
    CoachModelDTO coachMapper(CoachModel coach);

    @Mapping(target = "userInfoModel", ignore = true)
    CoachModel coachMapper(CoachModelDTO coachDTO);
}
