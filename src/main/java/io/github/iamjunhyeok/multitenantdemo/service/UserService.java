package io.github.iamjunhyeok.multitenantdemo.service;

import io.github.iamjunhyeok.multitenantdemo.domain.User;
import io.github.iamjunhyeok.multitenantdemo.mapper.UserMapper;
import io.github.iamjunhyeok.multitenantdemo.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public List<User> getUsers() {
    List<User> usingJpa = userRepository.findAll();
    List<User> usingMyBatis = userMapper.findAll();
    return usingJpa; // or usingMyBatis
  }
}
