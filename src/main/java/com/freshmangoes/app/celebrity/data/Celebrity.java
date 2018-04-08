package com.freshmangoes.app.celebrity.data;

import com.freshmangoes.app.common.data.Media;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.freshmangoes.app.common.data.Pair;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class Celebrity {
  //Todo Split this to break circular dependency
  private Integer id;
  private CelebrityType type;
  private URL profilePhoto;
  private Date birthday;
  private String name;
  private String birthplace;
  private String biography;
  private Media media;
  private Map<String, Pair> roles;
  private Content highestRated;
  private Content lowestRated;

}
