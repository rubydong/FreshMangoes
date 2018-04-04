package com.freshmangoes.app.celebrity.data;


import com.freshmangoes.app.common.data.Media;
import java.net.URL;
import java.util.Date;
import java.util.Map;

import com.freshmangoes.app.content.data.Content;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor

public class Celebrity {
  private Integer id;
  private CelebrityType type;
  private URL profilePhoto;
  private Date birthday;
  private String name;
  private String birthplace;
  private String biography;
  private Media media;
  private Map<String, String> roles;
  private Content highestRated;
  private Content lowestRated;

}
