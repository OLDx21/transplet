package com.mdemydovych.transplet.service;

import com.mdemydovych.transplet.exception.UserNotFoundException;
import com.mdemydovych.transplet.mapper.UserMapper;
import com.mdemydovych.transplet.model.UserDto;
import com.mdemydovych.transplet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  private final UserMapper userMapper;

  public Integer save(UserDto userDto) {
    final var toSave = userMapper.dtoToEntity(userDto);
    final var saved = userRepository.save(toSave);
    log.info("user with id:{} saved successfully!", saved.getUserId());
    return saved.getUserId();
  }

  public UserDto getUserById(Integer userId) {
    final var user = userRepository.findByUserId(userId)
        .orElseThrow(() -> {
          log.error("Cannot find user by id: {}", userId);
          return new UserNotFoundException("User not fount by id " + userId);
        });
    return userMapper.entityToDto(user);
  }

  public void deleteUser(Integer userId) {
    final var user = userRepository.findByUserId(userId)
        .orElseThrow(() -> {
          log.error("Cannot delete user by id: {}", userId);
          return new UserNotFoundException("User not fount by id " + userId);
        });
    userRepository.delete(user);
    log.info("user with id:{} deleted successfully!", userId);
  }

}
