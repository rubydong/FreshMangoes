package com.freshmangoes.app.home;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.home.data.IndexPageItems;
import com.freshmangoes.app.home.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  @Autowired
  private HomeService homeService;

  @GetMapping(Constants.INDEX_MAPPING)
  public IndexPageItems getIndexPage() {
    return homeService.getIndexPageItems();
  }

}
