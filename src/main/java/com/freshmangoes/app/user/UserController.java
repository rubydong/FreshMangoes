package com.freshmangoes.app.user;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(Constants.PROFILE_MAPPING)
  public User getProfile(@PathVariable final int userId) {
    return  userService.getUser(userId);
  }
}
