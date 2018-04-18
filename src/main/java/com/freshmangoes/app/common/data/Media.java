package com.freshmangoes.app.common.data;

import java.net.URL;

import java.util.List;

import com.freshmangoes.app.content.data.Content;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Media {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private URL path;
  @Column(name = "media_type")
  private MediaType type;

  @Builder
  public Media(Integer id, URL path, MediaType mediaType) {
    this.id = id;
    this.path = path;
    this.type = mediaType;
  }

  private Media() {};
}
