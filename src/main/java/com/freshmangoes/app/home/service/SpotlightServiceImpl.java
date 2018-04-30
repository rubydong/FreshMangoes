package com.freshmangoes.app.home.service;

import com.freshmangoes.app.content.repository.MovieRepository;
import com.freshmangoes.app.home.data.SpotlightItems;

import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SpotlightServiceImpl implements SpotlightService {

  @Autowired
  private MovieRepository movieRepository;

  @Override
  public SpotlightItems getIndexPageItems() {
    final Date currentDate = new Date();
    final Date weekFromToday;
    final Date monthFromToday;
    final Calendar c = Calendar.getInstance();

    c.setTime(currentDate);
    c.add(Calendar.WEEK_OF_MONTH, 1);
    weekFromToday = c.getTime();

    c.setTime(currentDate);
    c.add(Calendar.WEEK_OF_MONTH, 4);
    monthFromToday = c.getTime();

    return SpotlightItems.builder()
                         .openingThisWeek(movieRepository.findTop10ByMetadata_ReleaseDateGreaterThanEqualAndMetadata_ReleaseDateLessThanEqualOrderByMetadata_ReleaseDateDesc(currentDate, weekFromToday))
                         .topBoxOffice(movieRepository.findByOrderByRevenueDesc(PageRequest.of(0, 36)).getContent())
                         .comingSoon(movieRepository.findTop10ByMetadata_ReleaseDateGreaterThanEqualAndMetadata_ReleaseDateLessThanEqualOrderByMetadata_ReleaseDateDesc(currentDate, monthFromToday))
                         .certifiedFreshMovies(movieRepository.findTop10ByMetadata_MangoScoreGreaterThanOrderByMetadata_MangoScoreDesc(75.00))
                         .highestRatedMovies(movieRepository.findTop10ByMetadata_MangoScoreGreaterThanOrderByMetadata_MangoScoreDesc(0.0))
                         .build();
  }

  @Override
  public SpotlightItems getSpotlightItems() {
    return null;
  }
}
