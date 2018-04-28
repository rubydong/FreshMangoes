package com.freshmangoes.app.user;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private HttpSession session;

  @GetMapping(Constants.PROFILE_MAPPING)
  public User getProfile(@PathVariable final int userId) {
    User user = userService.getUser(userId);
    return user;
  }

  @PostMapping(Constants.CHANGE_NAME_MAPPING)
  public ResponseEntity changeDisplayName(@RequestBody final Map<String, String> body) {
    User user = (User) session.getAttribute(Constants.USER_ID);
    if (user != null) {
      userService.updateName(user, body.get(Constants.NEW_NAME));
      return new ResponseEntity(HttpStatus.OK);
    }
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }

  @PostMapping(Constants.CHANGE_PASSWORD_MAPPING)
  public ResponseEntity changePassword(@RequestBody final Map<String, String> body) {
    User user = (User) session.getAttribute(Constants.USER_ID);
    if (user != null) {
      userService.updatePassword(user, body.get(Constants.NEW_PASSWORD));
      return new ResponseEntity(HttpStatus.OK);
    }
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }

  @PostMapping(Constants.CHANGE_EMAIL_MAPPING)
  public ResponseEntity changeEmail(@RequestBody final Map<String, String> body) {
    User user = (User) session.getAttribute(Constants.USER_ID);
    if (user != null) {
      userService.updateEmail(user, body.get(Constants.NEW_EMAIL));
      return new ResponseEntity(HttpStatus.OK);
    }
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }

  @PostMapping(Constants.FORGOT_PASSWORD_MAPPING)
  public ResponseEntity forgotPassword(@RequestBody final Map<String, String> body) {
    if (userService.forgotPassword(body.get(Constants.PASSWORD))) {
      return new ResponseEntity(HttpStatus.OK);
    }
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }

  @PostMapping(Constants.DELETE_ACCOUNT_MAPPING)
  public ResponseEntity deleteAccount() {
    User user = (User) session.getAttribute(Constants.USER_ID);
    if (user != null) {
      userService.deleteAccount(user);
      session.invalidate();
      return new ResponseEntity(HttpStatus.OK);
    }
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }

  @PostMapping(Constants.CHANGE_PICTURE_MAPPING)
  public ResponseEntity editPicture(@RequestBody final Map<String, String> body) {
    User user = (User) session.getAttribute(Constants.USER_ID);
    if (user != null) {
      userService.updatePicture();
      return new ResponseEntity(HttpStatus.OK);
    }
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }

  @GetMapping(Constants.GET_ALL_CRITICS)
  public List<User> getAllCritics() {
    List<User> critics = userService.getCritics();
    Collections.sort(critics,
     (User o1, User o2)->((Integer)o2.getRatings().size()).compareTo((Integer)o1.getRatings().size()));
//    Collections.sort(critics, new Comparator<User>() {
//      @Override
//      public int compare(User o1, User o2) {
//        if (o1.getRatings().size() > o2.getRatings().size()) {
//          return -1;
//        } else if (o1.getRatings().size() < o2.getRatings().size()) {
//          return 1;
//        } else {
//          return 0;
//        }
//      }
//    });
    return critics;
  }
}
