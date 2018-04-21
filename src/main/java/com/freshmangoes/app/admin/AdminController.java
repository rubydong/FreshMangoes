package com.freshmangoes.app.admin;

import com.freshmangoes.app.admin.data.Report;
import com.freshmangoes.app.admin.service.AdminService;
import com.freshmangoes.app.common.data.Constants;
import java.util.Map;
import javax.servlet.http.HttpSession;
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
  private HttpSession session;

  @PostMapping(Constants.ADMIN_ADD_DETAIL_PAGE_MAPPING)
  public ResponseEntity createDetailPage(@RequestBody final Map<String, String> body) {
    final HttpStatus status;

    if (adminService.isAuthenticatedAdmin(session)) {
      if (body.get("type").equals("MOVIE")) {
        status = adminService.createMovieDetailPage(null) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
      } else {
        status = adminService.createShowDetailPage(null) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
      }
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return ResponseEntity.status(status).build();
  }

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
  public ResponseEntity<Object> getReports() {
    final HttpStatus status;
    final Report report;

    if (adminService.isAuthenticatedAdmin(session)) {
      status = HttpStatus.OK;
      report = adminService.getReport();
    } else {
      status = HttpStatus.BAD_REQUEST;
      report = null;
    }

    return ResponseEntity.status(status).body(report);
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
}
