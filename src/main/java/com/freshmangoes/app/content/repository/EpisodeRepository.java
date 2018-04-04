package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Episode;



public interface EpisodeRepository {
  Episode findEpisodeById(final int id);
}
