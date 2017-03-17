package com.recommender.service.util;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by swara on 19/01/2017.
 */
@Service
public class RecommenderUtils {


    /**
     * Create List from CSV values
     *
     * @param csvString
     * @return
     */
    public List<String> createListFromCSV(String csvString) {
        return Arrays.asList(csvString.split("\\s*,\\s*"));
    }

    public List<Long> createIntegerList(List<String> stringList) {

        List<Long> longList = new ArrayList<>();
        stringList.forEach(itemStringId ->
                longList.add(Long.getLong(itemStringId)));
        return longList;
    }

    public List<Long> createIntegerListString(String stringList) {

        List<Long> longList = new ArrayList<>();
        createListFromCSV(stringList).forEach(itemStringId ->
                longList.add(Long.getLong(itemStringId)));
        return longList;
    }
}
