package com.recommender.recommender.services;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swara on 12/01/2017.
 */
public interface GuestRecommendationService {

    public List<RecommendedItem> getGuestRecommendedItems(ArrayList<Long> items, double threshold, int howMany);
}
