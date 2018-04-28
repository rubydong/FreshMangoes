package com.freshmangoes.app.admin;

import com.freshmangoes.app.admin.service.AdminService;
import com.freshmangoes.app.common.data.Constants;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.rating.data.Rating;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
  @Autowired
  private AdminService adminService;

  @Autowired
  private EntityManager entityManager;

  @Autowired
  private HttpSession session;

//  @PostMapping(Constants.ADMIN_ADD_DETAIL_PAGE_MAPPING)
//  public Content createDetailPage(@RequestBody final String body) {
////    final HttpStatus status;
////
////    if (adminService.isAuthenticatedAdmin(session)) {
////      if (body.get("type").equals("MOVIE")) {
////        status = adminService.createMovieDetailPage(null) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
////      } else {
////        status = adminService.createShowDetailPage(null) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
////      }
////    } else {
////      status = HttpStatus.BAD_REQUEST;
////    }
//    Movie m = adminService.jsonToMovie(body);
////    System.out.println(m.getMetadata().getName());
//    return m;
//  }

  @PostMapping(Constants.ADMIN_UPDATE_DETAIL_PAGE_MAPPING)
  public ResponseEntity updateDetailPage(@RequestBody final Map<String, String> body) {
    final HttpStatus status;

    if (adminService.isAuthenticatedAdmin(session)) {
      if (body.get("type").equals("MOVIE")) {
        status = adminService.updateMovieDetailPage(null) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
      } else {
        status = adminService.updateShowDetailPage(null) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
      }
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return ResponseEntity.status(status).build();
  }

  @PostMapping(Constants.ADMIN_DELETE_DETAIL_PAGE_MAPPING)
  public ResponseEntity deleteDetailPage(@PathVariable final Integer contentId) {
    final HttpStatus status;

    if (adminService.isAuthenticatedAdmin(session)) {
      status = HttpStatus.OK;
      adminService.deleteDetailPage(contentId);
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return ResponseEntity.status(status).build();
  }

  @GetMapping(Constants.ADMIN_VIEW_REPORTS_MAPPING)
  public List<Rating> getReports() {
    List<Rating> reports = null;
    if (adminService.isAuthenticatedAdmin(session)) {
      reports = adminService.getReport();
    }
    return reports;
  }

  @PostMapping(Constants.ADMIN_DELETE_RATING_MAPPING)
  public ResponseEntity deleteRating(@PathVariable final Integer ratingId) {
    final HttpStatus status;

    if (adminService.isAuthenticatedAdmin(session)) {
      status = HttpStatus.OK;
      adminService.deleteRating(ratingId);
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return ResponseEntity.status(status).build();
  }

  @PostMapping(Constants.ADMIN_DELETE_USER_MAPPING)
  public ResponseEntity deleteUser(@PathVariable final Integer userId) {
    final HttpStatus status;

    if (adminService.isAuthenticatedAdmin(session)) {
      status = HttpStatus.OK;
      adminService.deleteUser(userId);
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return ResponseEntity.status(status).build();
  }

  @PostMapping(Constants.ADMIN_REINDEX_MAPPING)
  public ResponseEntity reindexDatabase() throws InterruptedException {
    FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
    fullTextEntityManager.createIndexer().startAndWait();
    return new ResponseEntity(HttpStatus.OK);
  }

  @PostMapping(Constants.ADMIN_APPROVE_CRITIC)
  public ResponseEntity approveCritic(@PathVariable final Integer userId) {
    final HttpStatus status;

    if (adminService.isAuthenticatedAdmin(session)) {
      status = adminService.approveUserToCritic(userId) != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return ResponseEntity.status(status).build();
  }
}
