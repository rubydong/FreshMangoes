package com.freshmangoes.app.content.data;

import com.freshmangoes.app.common.data.Media;
import lombok.Builder;
import java.util.List;



public class Show extends Content {
  private List<Season> seasons;

  @Builder
  public Show(Integer id,
              ContentType type,
              Media media,
              ContentMetadata contentMetadata,
              List<Season> seasons) {
    super.setId(id);
    super.setMedia(media);
    super.setMetadata(contentMetadata);
    super.setType(type);
    this.seasons = seasons;
  }
}
