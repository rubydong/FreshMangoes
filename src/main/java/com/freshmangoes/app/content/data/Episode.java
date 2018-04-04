package com.freshmangoes.app.content.data;


import com.freshmangoes.app.common.data.Media;
import lombok.Builder;


public class Episode extends Content {
  @Builder
  public Episode(Integer id,
                 ContentType type,
                 Media media,
                 ContentMetadata contentMetadata) {
    super.setId(id);
    super.setMedia(media);
    super.setType(type);
    super.setMetadata(contentMetadata);
  }
}
