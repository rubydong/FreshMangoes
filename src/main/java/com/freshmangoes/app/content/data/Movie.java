package com.freshmangoes.app.content.data;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;
import lombok.Builder;

import java.net.URL;
import java.util.List;


public class Movie extends Content {

  @Builder
  public Movie(Integer id,
               ContentType type,
               Media media,
               ContentMetadata contentMetadata,
               List<Rating> ratings,
               URL summaryPhoto) {
    super.setId(id);
    super.setMedia(media);
    super.setType(type);
    super.setMetadata(contentMetadata);
    super.setSummaryPhoto(summaryPhoto);
    super.setRatings(ratings);
  }
}