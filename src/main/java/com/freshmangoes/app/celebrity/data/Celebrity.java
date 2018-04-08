package com.freshmangoes.app.celebrity.data;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.common.data.Pair;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.Movie;
import java.net.URL;
import java.util.Date;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Celebrity {
  private Integer id;
  private celebrityType type;
  private URL profilePhoto;
  private Date birthday;
  private String name;
  private String birthplace;
  private String biography;
  private Media media;
  private Map<String, Pair<String,Movie>> roles;
  private Content highestRated;
  private Content lowestRated;
}
