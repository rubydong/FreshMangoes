package com.freshmangoes.app.search.data;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.Show;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
public class SearchResult {
  List<Celebrity> celebrities;
  List<Content> movies;
  List<Show> shows;
}
