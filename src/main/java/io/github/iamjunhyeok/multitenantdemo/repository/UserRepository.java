package io.github.iamjunhyeok.multitenantdemo.repository;

import io.github.iamjunhyeok.multitenantdemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}