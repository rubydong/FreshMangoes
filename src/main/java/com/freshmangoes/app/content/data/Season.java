package com.freshmangoes.app.content.data;

import java.util.List;
import lombok.Builder;



@Builder
public class Season {
  private List<Episode> episodes;
}
