package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.data.CelebrityType;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.common.data.Pair;
import com.freshmangoes.app.content.data.ContentMetadata;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.user.data.UserType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Repository;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class MySqlMovieRepository implements MovieRepository {
  @Override
  public Movie findMovieById(int id) {
    return null;
  }

  @Override
  public List<Movie> findAllMoviesLikeKeyword(String searchQuery) {
    return null;
  }
}
