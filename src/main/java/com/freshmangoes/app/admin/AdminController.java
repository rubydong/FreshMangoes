package com.freshmangoes.app.admin;

import com.freshmangoes.app.admin.service.AdminService;
import com.freshmangoes.app.common.data.Constants;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.user.data.Application;
import com.freshmangoes.app.user.data.User;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AdminController {
  @Autowired
  private AdminService adminService;

  @Autowired
  private EntityManager entityManager;

  @Autowired
  private HttpSession session;

  @PostMapping(Constants.ADMIN_ADD_DETAIL_PAGE_MAPPING)
  public Content createDetailPage(@RequestBody final String body) {
    Content content = null;
    if (adminService.isAuthenticatedAdmin(session)) {
      content = adminService.jsonToContent(body);
    }
    return content;
  }

  @PostMapping(Constants.ADMIN_UPDATE_DETAIL_SUMMARY_MAPPING)
  public Content updateDetailPageSummmary(@PathVariable final Integer contentId,
                                          @RequestBody final String body) {
    Content content = null;
    if (adminService.isAuthenticatedAdmin(session)) {
      content = adminService.editContentSummary(body, contentId);
    }
    return content;
  }

  @DeleteMapping(Constants.ADMIN_DELETE_MEDIA_MAPPING)
  public ResponseEntity deleteMedia(@PathVariable final String contentType,
                                    @PathVariable final Integer contentId,
                                    @PathVariable final Integer mediaId) {

    final HttpStatus status;

    if (adminService.isAuthenticatedAdmin(session)) {
      status = HttpStatus.OK;
      adminService.deleteMedia(contentId, ContentType.valueOf(contentType), mediaId);
    } else {
      status = HttpStatus.BAD_REQUEST;
    }
    return ResponseEntity.status(status).build();
  }

  @PostMapping(Constants.ADMIN_UPDATE_DETAIL_MEDIA_MAPPING)
  public Content updateDetailPageMedia(@PathVariable final Integer contentId,
                                       @RequestBody final String body) {
    Content content = null;
    if (adminService.isAuthenticatedAdmin(session)) {
      content = adminService.editMedia(body, contentId);
    }
    return content;
  }

  @DeleteMapping(Constants.ADMIN_DELETE_CAST_MAPPING)
  public ResponseEntity deleteCast(@PathVariable final String contentType,
                                   @PathVariable final Integer contentId,
                                   @PathVariable final Integer castId) {
    final HttpStatus status;

    if (adminService.isAuthenticatedAdmin(session)) {
      status = HttpStatus.OK;
      adminService.deleteCast(contentId, ContentType.valueOf(contentType), castId);
    } else {
      status = HttpStatus.BAD_REQUEST;
    }
    return ResponseEntity.status(status).build();
  }

  @PostMapping(Constants.ADMIN_UPDATE_DETAIL_CAST_MAPPING)
  public Content updateDetailPageCast(@PathVariable final Integer contentId,
                                      @RequestBody final String body) {
    adminService.editCast(body, contentId);
    return null;
  }

  @DeleteMapping(Constants.ADMIN_DELETE_DETAIL_PAGE_MAPPING)
  public ResponseEntity deleteDetailPage(@PathVariable final String contentType,
                                         @PathVariable final Integer contentId) {
    final HttpStatus status;

    if (adminService.isAuthenticatedAdmin(session)) {
      status = HttpStatus.OK;
      adminService.deleteDetailPage(contentId, ContentType.valueOf(contentType));
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

  @DeleteMapping(Constants.ADMIN_DELETE_RATING_MAPPING)
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

  @DeleteMapping(Constants.ADMIN_DELETE_USER_MAPPING)
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

  @GetMapping(Constants.ADMIN_GET_CRITIC_APPS)
  public List<Application> getCriticApplication() {
    if (adminService.isAuthenticatedAdmin(session)) {
      return adminService.getAllPotentialCritics();
    }
    return null;
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

  @PostMapping(Constants.ADMIN_DISMISS_REPORT)
  public ResponseEntity dismissReport(@PathVariable final Integer ratingId) {
    final HttpStatus status;

    if (adminService.isAuthenticatedAdmin(session)) {
      status = HttpStatus.OK;
      adminService.dismissReport(ratingId);
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return ResponseEntity.status(status).build();
  }

  @PostMapping(Constants.ADMIN_DISMISS_CRITIC_APP)
  public ResponseEntity dismissCriticApplication(@PathVariable final Integer userId) {
    final HttpStatus status;

    if (adminService.isAuthenticatedAdmin(session)) {
      status = HttpStatus.OK;
      adminService.dismissCriticApplication(userId);
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return ResponseEntity.status(status).build();
  }

  @PostMapping(value = Constants.ADMIN_UPLOAD_MEDIA,
               headers = "content-type=multipart/*",
               consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public String uploadMedia(@RequestParam("myImage") final MultipartFile file) {
    if (adminService.isAuthenticatedAdmin(session)) {
      return adminService.uploadMedia(file);
    }
    return null;
  }
}
