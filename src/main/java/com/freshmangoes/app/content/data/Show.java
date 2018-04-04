package com.freshmangoes.app.content.data;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;
import lombok.Builder;

import java.net.URL;
import java.util.List;



public class Show extends Content {
  private List<Season> seasons;

  @Builder
  public Show(Integer id,
              ContentType type,
              Media media,
              ContentMetadata contentMetadata,
              List<Season> seasons,
              List<Rating> ratings,
              URL summaryPhoto) {
    super.setId(id);
    super.setMedia(media);
    super.setMetadata(contentMetadata);
    super.setType(type);
    super.setSummaryPhoto(summaryPhoto);
    super.setRatings(ratings);
    this.seasons = seasons;
  }
}
