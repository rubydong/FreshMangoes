package com.freshmangoes.app.common.data;

import java.net.URL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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
}
