package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.*;

import java.util.List;




public interface ContentRepository {
  Movie findMovieById(int id);

  Show findShowById(int id);

  Season findSeasonById(int id);

  Episode findEpisodeById(int id);

  List<Content> findAllMoviesLikeKeyword(String searchQuery);

  List<Show> findAllShowsLikeKeyword(String searchQuery);
}
