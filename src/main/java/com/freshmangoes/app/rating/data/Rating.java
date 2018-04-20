package com.freshmangoes.app.rating.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.*;
import lombok.*;

@Entity(name = "Ratings")
@Data
@Builder
@Getter
@Setter
@Table(name = "Ratings")
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer score;
  private String body;

  @Column (name = "content_id")
  private Integer contentId;

  @JsonInclude()
  @Transient
  private String contentName;
}
