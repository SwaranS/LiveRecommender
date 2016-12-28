package com.recommender.web.controller;

/**
 * Created by Swaran on 18/12/2016.
 */

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
    private DriverManagerDataSource postGresDataSource;

    @Autowired
    private JobService jobService;

    private static int counter = 0;
    private static final String VIEW_INDEX = "index";
    private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        model.addAttribute("message", "Welcome");
        model.addAttribute("counter", ++counter);
        logger.debug("[welcome] counter : {}", counter);

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;

    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {
        System.out.println(jobService.insertJob(1, 1));
        model.addAttribute("message", "Welcome " + name);
        model.addAttribute("counter", jobService.insertJob(1, 1));
        logger.debug("[welcomeName] counter : {}", counter);
        return VIEW_INDEX;

    }
}
