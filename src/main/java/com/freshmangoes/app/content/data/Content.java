package com.freshmangoes.app.content.data;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;
import java.net.URL;
import java.util.List;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public abstract class Content {
  private Integer id;
  private ContentType type;
  private Media media;
  private ContentMetadata metadata;
  private URL summaryPhoto;
  private List<Rating> ratings;
}
