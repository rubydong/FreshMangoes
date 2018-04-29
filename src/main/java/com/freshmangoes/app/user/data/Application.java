package com.freshmangoes.app.user.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Application {
  private User user;
  private String statement;
}
