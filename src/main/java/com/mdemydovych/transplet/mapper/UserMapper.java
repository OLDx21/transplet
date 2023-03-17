package com.mdemydovych.transplet.mapper;

import com.mdemydovych.transplet.domain.User;
import com.mdemydovych.transplet.model.UserDto;
import com.mdemydovych.transplet.request.CreateUserRequest;
import com.mdemydovych.transplet.response.UserIdResponse;
import com.mdemydovych.transplet.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserDto requestToDto(CreateUserRequest createUserRequest);

  @Mapping(target = "id", ignore = true)
  User dtoToEntity(UserDto userDto);

  UserDto entityToDto(User user);

  UserIdResponse toResponse(Integer userId);

  UserResponse toResponse(UserDto userDto);
}
