package com.epsilon.jive;

import com.epsilon.jive.models.JiveContentWrapper;
import com.epsilon.jive.models.JiveJsonLink;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PlaceObjectConverter implements ObjectConverter {


    private final static Logger logger = LoggerFactory.getLogger(PlaceObjectConverter.class);

    @Override
    public JiveContentWrapper createJivePlace(String responseJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        JiveContentWrapper group = null;
        try {
            group = objectMapper.readValue(responseJson, JiveContentWrapper.class);
        } catch (IOException e) {
            logger.error("IO Error" + e);
        }
        return group;
    }

    public JiveJsonLink createJiveLink(String responseJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        JiveJsonLink group = null;
        try {
            group = objectMapper.readValue(responseJson, JiveJsonLink.class);
        } catch (IOException e) {
            logger.error("IO Error" + e);
        }
        return group;
    }

}
