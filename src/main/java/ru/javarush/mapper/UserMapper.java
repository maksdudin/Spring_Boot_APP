package ru.javarush.mapper;


import ru.javarush.dto.UserDto;
import ru.javarush.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "name", ignore = true)
    UserDto toUserDto(UserEntity userEntity);

    UserEntity toUserEntity(UserDto userDto);

}