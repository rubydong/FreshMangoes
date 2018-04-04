package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.*;

import java.util.List;




public interface ContentRepository {
  Movie findMovieById(final int id);

  Show findShowById(final int id);

  Season findSeasonById(final int id);

  Episode findEpisodeById(final int id);

  List<Movie> findAllMoviesLikeKeyword(final String searchQuery);

  List<Show> findAllShowsLikeKeyword(final String searchQuery);
}
