package com.freshmangoes.app.rating.data;

import com.freshmangoes.app.user.data.userType;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Rating {
  private Integer id;
  private Integer contentId;
  private Integer reviewerId;
  private Integer score;
  private String body;
  private userType type;
}
