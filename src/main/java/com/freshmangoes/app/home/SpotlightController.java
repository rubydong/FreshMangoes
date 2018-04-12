package com.freshmangoes.app.home;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.home.data.SpotlightItems;
import com.freshmangoes.app.home.service.SpotlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotlightController {
  @Autowired
  private SpotlightService homeService;

  @GetMapping(Constants.INDEX_MAPPING)
  public SpotlightItems getIndexPage() {
    return homeService.getIndexPageItems();
  }

}
