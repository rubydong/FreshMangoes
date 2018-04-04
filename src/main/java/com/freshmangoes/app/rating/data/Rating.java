package com.freshmangoes.app.rating.data;

import lombok.Data;
import lombok.Builder;


@Data
@Builder
public class Rating {
  private Integer id;
  private Integer contentId;
  private Integer reviewerId;
  private Integer score;
  private String body;
  private UserType type;
}
