package com.freshmangoes.app.content.data;

import java.util.List;

import com.freshmangoes.app.common.data.Media;
import lombok.Builder;



public class Season extends Content {
  private List<Episode> episodes;

  @Builder
  public Season(Integer id,
                ContentType type,
                Media media,
                ContentMetadata contentMetadata,
                List<Episode> episodes) {
    super.setId(id);
    super.setMedia(media);
    super.setMetadata(contentMetadata);
    super.setType(type);
    this.episodes = episodes;
  }
}
