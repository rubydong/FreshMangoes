package com.freshmangoes.app.search.data;

import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SearchCriteria {
  int rating;
  Date startDate;
  Date endDate;
  List<String> genres;
}
