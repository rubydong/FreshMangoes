package com.freshmangoes.app.verification;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.verification.service.VerificationService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class VerificationController {
  @Autowired
  private VerificationService verificationService;

  @Autowired
  private HttpSession session;

  @PostMapping(Constants.VERIFY_MAPPING)
  public ResponseEntity verify(@RequestParam final String verificationKey) {
    final HttpStatus status;
    final User user;

    user = verificationService.verifyUser(verificationKey);

    if (user != null) {
      session.setAttribute(Constants.USER_ID, user);
      status = HttpStatus.OK;
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }

  @PostMapping(Constants.RESEND_MAPPING)
  public ResponseEntity resendVerification(@RequestBody final Map<String, String> body) {
    final HttpStatus status;
    final String email;

    email = body.get(Constants.EMAIL);
    status = (verificationService.resendVerificationEmail(email)) ? HttpStatus.OK
                                                                  : HttpStatus.BAD_REQUEST;
    return new ResponseEntity(status);
  }
}
