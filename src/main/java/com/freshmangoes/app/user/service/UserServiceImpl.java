package com.freshmangoes.app.user.service;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.common.data.MediaType;
import com.freshmangoes.app.content.repository.MediaRepository;
import com.freshmangoes.app.email.service.EmailService;
import com.freshmangoes.app.rating.repository.RatingRepository;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RatingRepository ratingRepository;

  @Autowired
  private MediaRepository mediaRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private EmailService emailService;

  @Override
  public User getUser(final Integer userId) {
    final User user = userRepository.findById(userId).orElse(null);
//    user.setRatings(ratingRepository.findByUserId(userId));
    return user;
  }

  public User getUserByEmail(final String email) {
    final User user = userRepository.findByEmail(email);
    return user;
  }

  @Override
  public void updatePassword(User user, String s) {
    String hash = passwordEncoder.encode(s);
    user.setHash(hash);
    userRepository.save(user);
  }

  @Override
  public void updateEmail(User user, String email) {
    user.setEmail(email);
    userRepository.save(user);
  }

  @Override
  public Boolean forgotPassword(String email) {
    return emailService.sendEmail(email, "Fresh Mangoes Password Reset",
        "Click this link to reset your password: http://localhost:9000/resetpassword/");
  }

  @Override
  public void deleteAccount(User user) {
    userRepository.delete(user);
  }

  @Override
  public Boolean updatePicture(User user, MultipartFile mpf) {
    File f = new File(Constants.FILE_PATH + mpf.getOriginalFilename());
    try {
      if (!f.getParentFile().exists()) {
        f.getParentFile().mkdirs();
      }
      if (!f.exists()) {
        f.createNewFile();
        mpf.transferTo(f);
        Media media = new Media();
        media.setPath(f.getCanonicalPath());
        media.setType(MediaType.PHOTO);
        mediaRepository.save(media);
        user.setProfilePicture(media);
        userRepository.save(user);
        return true;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public void updateName(User user, String name) {
    user.setDisplayName(name);
    userRepository.save(user);
  }

  @Override
  public List<User> getCritics() {
    List<User> critics = userRepository.getAllCritics();
    critics.sort((User o1, User o2) -> Integer.compare(o2.getRatings().size(), o1.getRatings().size()));
    return critics;
  }

  @Override
  public Boolean applyForCritic(Integer userId, String statement) {
    final User user = userRepository.findById(userId).orElse(null);
    if (user == null || userRepository.appliedForCritic(userId) != null) {
      return false;
    }
    return userRepository.applyForCritic(userId, statement) != null;
  }

  public void updateViews(User user, BigInteger views) {
    user.setViews(views);
    userRepository.save(user);
  }
}
