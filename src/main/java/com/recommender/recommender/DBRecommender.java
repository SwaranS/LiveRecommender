package com.recommender.recommender;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.PostgreSQLBooleanPrefJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Swaran on 03/01/2017.
 */
@Service
public class DBRecommender {

    @Autowired
    private DataSource dataSource;

    public List<RecommendedItem> getRecommendations() {
        List<RecommendedItem> recommendedItems = new ArrayList<>();
        DataModel model = getUserSkillsDataModel();
        UserSimilarity similarity = new TanimotoCoefficientSimilarity(model);
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
        UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        try {
            recommendedItems = recommender.recommend(2, 6);
        } catch (TasteException e) {
            e.printStackTrace();
        }
        return recommendedItems;
    }

    private DataModel getUserSkillsDataModel() {
        DataModel skillDataModel =
                new PostgreSQLBooleanPrefJDBCDataModel(dataSource, "userSkills", "userId", "skillId", null);
        return skillDataModel;
    }
}
