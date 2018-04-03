package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Content;




public interface ContentRepository {
  Content findMovieById(int id);

  Content findShowById(int id);

  Content findSeasonById(int id);

  Content findEpisodeById(int id);
}
