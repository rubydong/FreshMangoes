package com.freshmangoes.app.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.freshmangoes.app.auth.service.AuthService;
import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.common.helpers.Helpers;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.verification.service.VerificationService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
  @Autowired
  private AuthService authService;

  @Autowired
  private VerificationService verificationService;

  @Autowired
  private HttpSession session;

  @Autowired
  private ObjectMapper mapper;

  @PostMapping(Constants.LOGIN_MAPPING)
  public ResponseEntity login(@RequestBody final Map<String, String> body) {
    final HttpStatus status;
    final User user;

    user = authService.loginUser(body.get(Constants.EMAIL),
                                 body.get(Constants.PASSWORD));

    if (user != null) {
      session.setAttribute(Constants.USER_ID, user);
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

  @PostMapping(Constants.REGISTER_MAPPING)
  public ResponseEntity register(@RequestBody final Map<String, String> body) {
    final HttpStatus status;
    final User user;
    final String email = body.get(Constants.EMAIL);

    user = authService.registerUser(email,
                                      body.get(Constants.PASSWORD),
                                      body.get(Constants.DISPLAY_NAME));

    if (user != null) {
      status = (verificationService.sendVerificationEmail(user)) ? HttpStatus.OK
                                                                 : HttpStatus.BAD_REQUEST;
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }

  @GetMapping(value = Constants.CURRENT_USER_MAPPING, produces = Constants.APPLICATION_JSON)
  public String currentUser() {
    final User user = Helpers.getAuthenticatedUser(session);
    final ObjectNode rootNode = mapper.createObjectNode();

    if (user != null) {
      rootNode.put(Constants.USER_ID, user.getId());
    }

    return rootNode.toString();
  }
}
