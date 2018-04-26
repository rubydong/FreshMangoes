package com.freshmangoes.app.admin.service;

import com.freshmangoes.app.admin.data.Report;
import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Show;
import com.freshmangoes.app.content.repository.MovieRepository;
import com.freshmangoes.app.content.repository.ShowRepository;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.rating.repository.RatingRepository;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.data.UserType;
import com.freshmangoes.app.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private ShowRepository showRepository;

  @Autowired
  private RatingRepository ratingRepository;

  @Autowired
  private UserRepository userRepository;

  @Override
  public Boolean createMovieDetailPage(final Movie movie) {
    movieRepository.save(movie);
    return null;
  }

  @Override
  public Boolean createShowDetailPage(final Show show) {
    showRepository.save(show);
    return null;
  }

  @Override
  public Boolean updateMovieDetailPage(final Movie movie) {
    return null;
  }

  @Override
  public Boolean updateShowDetailPage(final Show show) {
    return null;
  }

  @Override
  public void deleteDetailPage(final Integer contentId) {
    /*
      Since movieRepository and showRepository point to `Content` table,
      deleting from one of the two repositories will do the job.
    */
    movieRepository.deleteById(contentId);
  }

  @Override
  public List<Rating> getReport() {
    return ratingRepository.findFlaggedRatings();
  }

  @Override
  public void deleteRating(final Integer ratingId) {
    ratingRepository.deleteById(ratingId);
  }

  @Override
  public void deleteUser(final Integer userId) {
    userRepository.deleteById(userId);
  }

  @Override
  public Boolean isAuthenticatedAdmin(final HttpSession session) {
    final User user = (User) session.getAttribute(Constants.USER_ID);
    return (user != null && user.getType() == UserType.ADMIN);
  }
}
