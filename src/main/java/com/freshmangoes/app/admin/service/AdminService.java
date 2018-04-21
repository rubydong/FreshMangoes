package com.freshmangoes.app.admin.service;

import com.freshmangoes.app.admin.data.Report;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Show;

import javax.servlet.http.HttpSession;

public interface AdminService {
  Boolean createMovieDetailPage(Movie movie);

  Boolean createShowDetailPage(Show show);

  Boolean updateMovieDetailPage(Movie movie);

  Boolean updateShowDetailPage(Show show);

  void deleteDetailPage(Integer contentId);

  Report getReport();

  void deleteRating(Integer ratingId);

  void deleteUser(Integer userId);

  Boolean isAuthenticatedAdmin(HttpSession session);
}
