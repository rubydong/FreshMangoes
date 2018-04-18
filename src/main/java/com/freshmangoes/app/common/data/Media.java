package com.freshmangoes.app.common.data;

import java.net.URL;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Media {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private URL path;
  @Column(name = "media_type")
  private MediaType type;

}
