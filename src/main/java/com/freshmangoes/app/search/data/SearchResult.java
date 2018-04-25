package com.freshmangoes.app.search.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.content.data.Content;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchResult {
  @JsonIgnoreProperties({"birthday", "birthplace", "biography", "media", "roles", "jobs"})
  List<Celebrity> celebrities;
  @JsonIgnoreProperties({"seasons", "episodes", "media", "ratings", "cast", "crew"})
  List<Content> content;
}
