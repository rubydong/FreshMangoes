package com.freshmangoes.app.content.data;

import java.util.List;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class Season {
  private List<Content> episodes;
}
