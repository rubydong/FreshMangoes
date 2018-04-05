package com.freshmangoes.app.content.data;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;
import java.net.URL;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
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
