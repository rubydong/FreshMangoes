package com.freshmangoes.app.content.data;

import com.freshmangoes.app.common.data.Media;
import lombok.Builder;



public class Movie extends Content {

  @Builder
  public Movie(Integer id,
               ContentType type,
               Media media,
               ContentMetadata contentMetadata) {
    super.setId(id);
    super.setMedia(media);
    super.setType(type);
    super.setMetadata(contentMetadata);
  }
}
