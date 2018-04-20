package com.freshmangoes.app.rating.data;

import lombok.Builder;
import lombok.Data;
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

  @Column(name = "score")
  private Integer score;

  @Column(name = "body")
  private String body;

  @Column(name = "content_id")
  private Integer contentId;

  @Column(name = "user_id")
  private Integer userId;

  @JsonInclude()
  @Transient
  private String contentName;
}
