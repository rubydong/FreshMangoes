package com.freshmangoes.app.content.service;

import com.freshmangoes.app.content.data.Content;



public interface ContentServiceIntf {
  Content findMovieById(int id);

  Content findShowById(int id);

  Content findSeasonById(int id);

  Content findEpisodeById(int id);
}
