package com.freshmangoes.app.user.data;

import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.rating.data.Rating;
import java.net.URL;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
  private Integer id;
  private String email;
  private String hash;
  private String displayName;
  private userType type;
  private URL profilePicture;
  private Integer numFollowers;
  private Integer numFollowing;
  private List<Integer> followers;
  private List<Integer> following;
  private List<Content> interestedList;
  private List<Content> disinterestedList;
  private List<Rating> reviews;
}
