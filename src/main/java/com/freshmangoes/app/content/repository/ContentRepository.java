package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.Show;

import java.util.List;




public interface ContentRepository {
  Content findMovieById(int id);

  Content findShowById(int id);

  Content findSeasonById(int id);

  Content findEpisodeById(int id);

  List<Content> findAllMoviesLikeKeyword(String searchQuery);

  List<Show> findAllShowsLikeKeyword(String searchQuery);
}
