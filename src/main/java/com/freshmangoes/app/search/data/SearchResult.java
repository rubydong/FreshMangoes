package com.freshmangoes.app.search.data;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Show;
import java.util.List;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SearchResult {
  List<Celebrity> celebrities;
  List<Movie> movies;
  List<Show> shows;
}
