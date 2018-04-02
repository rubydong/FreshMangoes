package com.freshmangoes.app.content.data;



public interface ContentRepositoryInterface {
  Content findMovieById(int id);

  Content findShowById(int id);

  Content findSeasonById(int id);

  Content findEpisodeById(int id);
}
