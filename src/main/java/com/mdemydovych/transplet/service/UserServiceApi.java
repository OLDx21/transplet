package com.mdemydovych.transplet.service;

import com.mdemydovych.transplet.mapper.UserMapper;
import com.mdemydovych.transplet.request.CreateUserRequest;
import com.mdemydovych.transplet.response.UserIdResponse;
import com.mdemydovych.transplet.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceApi {

  private final UserService userService;

  private final UserMapper userMapper;

  public UserIdResponse save(CreateUserRequest createUserRequest) {
    final var toSave = userMapper.requestToDto(createUserRequest);
    return userMapper.toResponse(userService.save(toSave));
  }

  public UserResponse get(Integer userId) {
    final var user = userService.getUserById(userId);
    return userMapper.toResponse(user);
  }

  public void delete(Integer userId) {
    userService.deleteUser(userId);
  }

}
