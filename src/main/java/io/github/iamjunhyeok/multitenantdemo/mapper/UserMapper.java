package io.github.iamjunhyeok.multitenantdemo.mapper;

import io.github.iamjunhyeok.multitenantdemo.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  List<User> findAll();
}
