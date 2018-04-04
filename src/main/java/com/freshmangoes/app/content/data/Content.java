package com.freshmangoes.app.content.data;

import com.freshmangoes.app.common.data.Media;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class Content {
  private Integer id;
  private ContentType type;
  private Media media;
  private ContentMetadata metadata;
}
