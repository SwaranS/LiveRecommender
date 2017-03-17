package com.recommender.service.rest;

import com.recommender.recommender.services.GuestRecommendationService;
import com.recommender.service.util.RecommenderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swara on 19/01/2017.
 */
@Service
public class RecommenderRestDelegateImpl implements RecommenderRestDelegate {

    @Autowired
    private GuestRecommendationService guestRecommendationService;

    @Autowired
    private RecommenderUtils recommenderUtils;

    /**
     * @param skills
     * @return
     */
    public ResponseEntity<String> generateMatchingSkillsResponse(String skills) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(guestRecommendationService.getGuestRecommendedItems(recommenderUtils.createIntegerListString(skills), 0.1, 20).toString()
                , httpHeaders, HttpStatus.OK);
    }


}
