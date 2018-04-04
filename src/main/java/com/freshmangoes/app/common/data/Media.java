package com.freshmangoes.app.common.data;

import java.net.URL;
import java.util.List;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class Media {
  private List<URL> photos;
  private List<URL> videos;
}
