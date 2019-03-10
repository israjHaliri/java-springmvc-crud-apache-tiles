package com.nicenetwork.controller.backend;

import com.nicenetwork.dao.LandingPageDao;
import com.nicenetwork.model.LandingPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gsp on 12/07/2016.
 */

@RestController
public class RestFullController {

    private final Logger LOGGER = LoggerFactory.getLogger(RestFullController.class);

    @Autowired
    LandingPageDao landingPageService;

    LandingPage landingPage = new LandingPage();

    @RequestMapping(value = "api/landing_page",  method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<LandingPage>  getAllJSON(Model model)
    {
        List<LandingPage> param = landingPageService.getData(1,5,"");
        LOGGER.debug("testing parameter = {}",param);
        return param;
    }


}
