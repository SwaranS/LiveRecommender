package com.recommender.service.rest;

import org.springframework.http.ResponseEntity;

/**
 * Created by swara on 19/01/2017.
 */

public interface RecommenderRestDelegate {

    public ResponseEntity<String> generateMatchingSkillsResponse(String skills);
}
