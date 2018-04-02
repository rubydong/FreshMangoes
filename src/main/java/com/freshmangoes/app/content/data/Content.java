package com.freshmangoes.app.content.data;

import com.freshmangoes.app.common.data.Media;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class Content {
  private Integer id;
  private ContentType type;
  private Media media;
  private ContentMetadata metadata;
}
