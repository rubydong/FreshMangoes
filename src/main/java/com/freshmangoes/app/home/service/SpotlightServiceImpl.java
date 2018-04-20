package com.freshmangoes.app.home.service;

import com.freshmangoes.app.content.data.ContentMetadata;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Show;
import com.freshmangoes.app.home.data.SpotlightItems;

import com.google.common.collect.ImmutableList;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class SpotlightServiceImpl implements SpotlightService {
  // Decide how to categorize Movies/Shows

  @Override
  public SpotlightItems getIndexPageItems() {
    return null;
  }

  @Override
  public SpotlightItems getSpotlightItems() {
    return null;
  }
}
