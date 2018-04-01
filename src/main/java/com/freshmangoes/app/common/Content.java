package com.freshmangoes.app.common;


import com.freshmangoes.app.common.ContentMetadata;
import com.freshmangoes.app.common.ContentType;
import com.freshmangoes.app.common.Media;



public abstract class Content {
  private Integer id;
  private ContentType type;
  private Media media;
  private ContentMetadata metadata;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ContentType getType() {
    return type;
  }

  public void setType(ContentType type) {
    this.type = type;
  }

  public Media getMedia() {
    return media;
  }

  public void setMedia(Media media) {
    this.media = media;
  }

  public ContentMetadata getMetadata() {
    return metadata;
  }

  public void setMetadata(ContentMetadata metadata) {
    this.metadata = metadata;
  }
}
