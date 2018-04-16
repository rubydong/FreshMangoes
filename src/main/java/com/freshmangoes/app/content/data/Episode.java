package com.freshmangoes.app.content.data;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;

import java.net.URL;

import java.util.List;

import lombok.Builder;

import javax.persistence.Entity;

//@Entity (name = "Episode")
public class Episode extends Content {
  @Builder
  public Episode(Integer id,
                 ContentType type,
                 Media media,
                 ContentMetadata contentMetadata,
                 List<Rating> ratings,
                 URL summary) {
    super.setId(id);
    //super.setMedia(media);
    super.setType(type);
    super.setMetadata(contentMetadata);
    //super.setSummaryPhoto(summaryPictur);
//    super.setRatings(ratings);
  }
}
