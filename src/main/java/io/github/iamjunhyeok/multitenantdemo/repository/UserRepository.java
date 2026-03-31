package io.github.iamjunhyeok.multitenantdemo.repository;

import io.github.iamjunhyeok.multitenantdemo.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

  @Query("select u from User u where u.username = :username")
  Optional<User> findByUsername(String username);

}