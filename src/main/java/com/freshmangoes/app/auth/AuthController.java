package com.freshmangoes.app.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.user.service.UserService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

  @Autowired
  private UserService userService;

  @Autowired
  private HttpSession session;

  @Autowired
  private ObjectMapper mapper;

  @CrossOrigin(origins = "http://localhost:8080")
  @PostMapping(Constants.LOGIN_MAPPING)
  public ResponseEntity login(@RequestBody final Map<String, String> body) {
    final HttpStatus status;
    final Integer userId;

    userId = userService.loginUser(body.get(Constants.EMAIL),
                                   body.get(Constants.PASSWORD));

    if (userId != null) {
      session.setAttribute(Constants.USER_ID, userId);
      status = HttpStatus.OK;
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }

  @PostMapping(Constants.LOGOUT_MAPPING)
  public ResponseEntity logout() {
    session.invalidate();
    return new ResponseEntity(HttpStatus.OK);
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @PostMapping(Constants.REGISTER_MAPPING)
  public ResponseEntity register(@RequestBody final Map<String, String> body) {
    final Integer userId;

    userId = userService.registerUser(body.get(Constants.EMAIL),
                                      body.get(Constants.PASSWORD),
                                      body.get(Constants.DISPLAY_NAME));

    return new ResponseEntity((userId != null) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping(value = Constants.CURRENT_USER_MAPPING, produces = "application/json")
  public String currentUser() {
    final Integer userId = (Integer) session.getAttribute(Constants.USER_ID);
    final ObjectNode rootNode = mapper.createObjectNode();

    if (userId != null) {
      rootNode.put(Constants.USER_ID, userId);
    }

    return rootNode.toString();
  }

}
