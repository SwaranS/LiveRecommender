package com.controller;

import com.recommender.recommender.services.GuestRecommendationService;
import com.recommender.service.rest.RecommenderRestDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * Created by Home on 04/01/2017.
 */
@Controller
@RequestMapping("/recommender")
public class RecommenderController {

    @Autowired
    @Qualifier("guestRecommendationLogServiceImpl")
    private GuestRecommendationService guestRecommendationService;

    @Autowired
    @Qualifier("recommenderRestDelegateImpl")
    private RecommenderRestDelegate recommenderRestDelegate;


    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> recommenderResponse() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ArrayList<Long> items = new ArrayList<>();
        items.add(2L);
        System.out.println(guestRecommendationService.getGuestRecommendedItems(items, 0.1, 20));
        return new ResponseEntity<>("{\"test\": \"jsonResponseExample\"}", httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/matchingSkills/{skills}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> matchingSkills(@PathVariable String skills) {
        return recommenderRestDelegate.generateMatchingSkillsResponse(skills);
    }

}
