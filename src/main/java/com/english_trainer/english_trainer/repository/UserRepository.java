package com.english_trainer.english_trainer.repository;

import com.english_trainer.english_trainer.domain.User;
import lombok.NonNull;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  

    Optional<User> findUserByUsername(String username);

    User findByUsername(String username);
}
