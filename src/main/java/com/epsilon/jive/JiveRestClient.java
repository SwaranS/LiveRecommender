package com.epsilon.jive;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Service
public class JiveRestClient {

    private String groupUrl = "https://community.jivesoftware.com/api/core/v3/places/1230885/contents";


    public String projectReader(String groupId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(this.groupUrl, HttpMethod.GET, createAuthHttpEntity(), String.class);
        return result.getBody();
    }


    //TODO: Move Rest credentials to
    public HttpEntity createAuthHttpEntity() {
        String authStr = "";
        String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        HttpEntity request = new HttpEntity(headers);
        return request;
    }
}
