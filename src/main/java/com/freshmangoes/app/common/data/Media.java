package com.freshmangoes.app.common.data;


import lombok.Data;

import java.net.URL;
import java.util.List;


@Data
public class Media {
  private List<URL> photos;
  private List<URL> videos;

  public Media() {

  }

  public List<URL> getPhotos() {
    return photos;
  }

  public void setPhotos(List<URL> photos) {
    this.photos = photos;
  }

  public List<URL> getVideos() {
    return videos;
  }

  public void setVideos(List<URL> videos) {
    this.videos = videos;
  }
}
