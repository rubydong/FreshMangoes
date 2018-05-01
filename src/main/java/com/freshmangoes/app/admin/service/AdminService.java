package com.freshmangoes.app.admin.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.freshmangoes.app.admin.data.Report;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Show;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.user.data.Application;
import com.freshmangoes.app.user.data.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface AdminService {
  void deleteDetailPage(Integer contentId, ContentType type);

  List<Rating> getReport();

  void deleteRating(Integer ratingId);

  void deleteUser(Integer userId);

  Boolean isAuthenticatedAdmin(HttpSession session);

  Content jsonToContent(String json);

  List<Application> getAllPotentialCritics();

  User approveUserToCritic(Integer userId);

  String uploadMedia(MultipartFile file);

  Content editContentSummary(String json, Integer contentId);

  Content editCast(String json, Integer contentId);

  Content editMedia(String json, Integer contentId);

  void deleteCast(Integer contentId, ContentType contentType, Integer celebrityId);

  void deleteMedia(Integer contentId, ContentType contentType, Integer mediaId);
}
