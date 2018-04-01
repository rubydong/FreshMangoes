package com.freshmangoes.app.celebrity.data;


import java.net.URL;
import java.util.Date;
import java.util.List;


import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.common.data.Media;



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
}
