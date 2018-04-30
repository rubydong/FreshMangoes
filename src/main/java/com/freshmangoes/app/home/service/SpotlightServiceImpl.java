package com.freshmangoes.app.home.service;

import com.freshmangoes.app.content.repository.MovieRepository;
import com.freshmangoes.app.content.service.ContentService;
import com.freshmangoes.app.home.data.SpotlightItems;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpotlightServiceImpl implements SpotlightService {

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private ContentService contentService;

  @Override
  public SpotlightItems getIndexPageItems() {
    final Date today;
    final Date tomorrow;
    final Date twoWeeksAgo;
    final Date weekFromToday;
    final Date monthFromToday;
    final Calendar c;

    c = new GregorianCalendar();
    c.set(Calendar.HOUR_OF_DAY, 0);
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    c.set(Calendar.MILLISECOND, 0);
    today = c.getTime();

    c.set(Calendar.HOUR_OF_DAY, 23);
    c.set(Calendar.MINUTE, 59);
    c.set(Calendar.SECOND, 59);
    c.set(Calendar.MILLISECOND, 59);
    tomorrow = c.getTime();

    c.setTime(today);
    c.add(Calendar.WEEK_OF_MONTH, -2);
    twoWeeksAgo = c.getTime();

    c.setTime(today);
    c.add(Calendar.WEEK_OF_MONTH, 1);
    weekFromToday = c.getTime();

    c.setTime(today);
    c.add(Calendar.WEEK_OF_MONTH, 4);
    monthFromToday = c.getTime();

    return SpotlightItems.builder()
                         .openingThisWeek(
                             contentService.findMovieByReleaseDateRange(today, weekFromToday
                             ))
                         .topBoxOffice(contentService.findMoviesByRevenue(0, 10))
                         .comingSoon(
                             contentService.findMovieByReleaseDateRange(today, monthFromToday
                             ))
                         .certifiedFreshMovies(
                             contentService.findTop10MoviesWithMangoScoreGreaterThan(75.00
                             ))
                         .highestRatedMovies(
                             contentService.findTop10MoviesWithMangoScoreGreaterThan(0.00
                             ))
                         .newTonight(contentService.findShowsByReleaseDateRange(today, tomorrow))
                         .mostPopular(contentService.findPopularShowsDateRange(twoWeeksAgo, today))
                         .certifiedFreshShows(contentService.findTop10ShowsWithMangoScoreGreaterThan(75.00))
                         .highestRatedShows(contentService.findTop10ShowsWithMangoScoreGreaterThan(0.00))
                         .build();
  }

  @Override
  public SpotlightItems getSpotlightItems() {
    return null;
  }
}
