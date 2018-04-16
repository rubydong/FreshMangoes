package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.common.data.Pair;
import com.freshmangoes.app.content.data.*;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.user.data.UserType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlShowRepository implements ShowRepository {
  @Override
  public Show findShowById(int id) {
    return null;
  }

  @Override
  public List<Show> findAllShowsLikeKeyword(String searchQuery) {
    return null;
  }
}
