package io.github.iamjunhyeok.multitenantdemo.mapper;

import io.github.iamjunhyeok.multitenantdemo.domain.User;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  List<User> findAll();

  Optional<User> findByUsername(String username);
}
