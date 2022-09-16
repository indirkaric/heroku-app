package com.indir.heroku.app.logic.mapper;

import com.indir.heroku.app.domain.dto.CreateUserDto;
import com.indir.heroku.app.domain.dto.UserDto;
import com.indir.heroku.app.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);
    User toEntity(CreateUserDto createUserDto);
}
