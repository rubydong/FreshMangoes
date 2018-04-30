package com.freshmangoes.app.admin.data;

import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.user.data.User;
import java.util.List;
import lombok.Builder;

@Builder
public class Report {
  private List<Rating> ratings;
  private List<User> users;
}
