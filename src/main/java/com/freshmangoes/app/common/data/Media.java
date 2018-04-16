package com.freshmangoes.app.common.data;

import java.net.URL;

import java.util.List;

import com.freshmangoes.app.content.data.Content;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class Media {
  @Id
  private int id;
  private URL path;
  @Column(name = "media_type")
  private MediaType type;
}
