package com.mdemydovych.transplet.repository;

import com.mdemydovych.transplet.domain.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

  Optional<User> findByUserId(Integer userId);

}
