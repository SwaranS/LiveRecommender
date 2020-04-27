package com.controller;

/**
 * Created by Swaran on 18/12/2016.
 */

import com.epsilon.jive.JiveRestClient;
import com.epsilon.jive.PlaceObjectConverter;
import com.recommender.recommender.DBRecommender;
import com.recommender.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {


    @Autowired
    private JiveRestClient restClient;

    @Autowired
    private PlaceObjectConverter objectConverter;


    private static int counter = 0;
    private static final String VIEW_INDEX = "index";
    private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        model.addAttribute("message", "Welcome");
        model.addAttribute("counter", ++counter);

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;

    }

    @RequestMapping(value = "/{groupId}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String groupId, ModelMap model) {
        String groupDetails = restClient.projectReader(groupId);
        model.addAttribute("group", objectConverter.createJivePlace(groupDetails));


        logger.debug("[welcomeName] counter : {}", counter);
        return VIEW_INDEX;

    }
}
