package com.freshmangoes.app.user;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.service.UserService;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
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
    //userService.updateViews(user, user.getViews().add(BigInteger.ONE));
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
    if (userService.forgotPassword(body.get(Constants.EMAIL))) {
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

  @RequestMapping(value = Constants.CHANGE_PICTURE_MAPPING, headers = "content-type=multipart/*", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public ResponseEntity editPicture(@RequestParam("myImage") final MultipartFile file) {
    User user = (User) session.getAttribute(Constants.USER_ID);
    if (user != null) {
      if (userService.updatePicture(file)) {
        return new ResponseEntity(HttpStatus.OK);
      }
    }
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }

  @PostMapping(Constants.RESET_PASSWORD_MAPPING)
  public ResponseEntity resetPassword(@RequestBody final Map<String, String> body) {
    User user = userService.getUserByEmail(body.get(Constants.EMAIL));
    if (user != null) {
      userService.updatePassword(user, body.get(Constants.NEW_PASSWORD));
      return new ResponseEntity(HttpStatus.OK);
    }
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }

  @GetMapping(Constants.GET_ALL_CRITICS)
  public List<User> getAllCritics() {
    return userService.getCritics();
  }

  @PostMapping(Constants.APPLY_FOR_CRITIC)
  public ResponseEntity applyForCritic(@RequestBody final Map<String, String> body) {
    HttpStatus status;

    User user = (User) session.getAttribute(Constants.USER_ID);
    if (user != null) {
      status = userService.applyForCritic(user.getId(), body.get(Constants.BODY))
          ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return ResponseEntity.status(status).build();
  }
}
