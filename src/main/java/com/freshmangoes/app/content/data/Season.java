package com.freshmangoes.app.content.data;

import java.net.URL;
import java.util.List;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;
import lombok.Builder;



public class Season extends Content {
  private List<Episode> episodes;

  @Builder
  public Season(Integer id,
                ContentType type,
                Media media,
                ContentMetadata contentMetadata,
                List<Episode> episodes,
                List<Rating> ratings,
                URL summaryPhoto) {
    super.setId(id);
    super.setMedia(media);
    super.setMetadata(contentMetadata);
    super.setType(type);
    super.setSummaryPhoto(summaryPhoto);
    super.setRatings(ratings);
    this.episodes = episodes;
  }
}
