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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CelebrityType getType() {
    return type;
  }

  public void setType(CelebrityType type) {
    this.type = type;
  }

  public URL getProfilePhoto() {
    return profilePhoto;
  }

  public void setProfilePhoto(URL profilePhoto) {
    this.profilePhoto = profilePhoto;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBirthplace() {
    return birthplace;
  }

  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }

  public String getBiography() {
    return biography;
  }

  public void setBiography(String biography) {
    this.biography = biography;
  }

  public Media getMedia() {
    return media;
  }

  public void setMedia(Media media) {
    this.media = media;
  }

  public List<Content> getRoles() {
    return roles;
  }

  public void setRoles(List<Content> roles) {
    this.roles = roles;
  }
}
