package com.mdemydovych.transplet.controller;

import com.mdemydovych.transplet.request.CreateUserRequest;
import com.mdemydovych.transplet.response.UserIdResponse;
import com.mdemydovych.transplet.response.UserResponse;
import com.mdemydovych.transplet.service.UserServiceApi;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

  private final UserServiceApi userServiceApi;

  @PostMapping(value = "save")
  public UserIdResponse save(@Valid @RequestBody CreateUserRequest createUserRequest) {
    return userServiceApi.save(createUserRequest);
  }

  @GetMapping(value = "{userId}")
  public UserResponse get(@PathVariable @NotNull Integer userId) {
    return userServiceApi.get(userId);
  }

  @DeleteMapping(value = "delete/{userId}")
  public void delete(@PathVariable @NotNull Integer userId) {
    userServiceApi.delete(userId);
  }

}
