package com.freshmangoes.app.celebrity;


import java.net.URL;
import java.util.Date;
import java.util.List;


import com.freshmangoes.app.celebrity.CelebrityType;
import com.freshmangoes.app.common.Content;
import com.freshmangoes.app.common.Media;


public class Celebrity {
  private Integer id;
  private CelebrityType type;
  private URL profilePhoto;
  private Date birthday;
  private String name;
  private String birthplace;
  private String biography;
  private Media media;
  private List<Content> roles;

  public Celebrity() {

  }
}
