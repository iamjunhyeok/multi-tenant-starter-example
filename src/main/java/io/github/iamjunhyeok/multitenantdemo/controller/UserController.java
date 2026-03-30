package io.github.iamjunhyeok.multitenantdemo.controller;

import io.github.iamjunhyeok.multitenant.web.RequireTenant;
import io.github.iamjunhyeok.multitenantdemo.domain.User;
import io.github.iamjunhyeok.multitenantdemo.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @RequireTenant
  @GetMapping("/users")
  public List<User> getUsers() {
    return userService.getUsers();
  }
}
