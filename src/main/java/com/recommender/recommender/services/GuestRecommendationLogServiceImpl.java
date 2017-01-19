package com.recommender.recommender.services;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.BooleanUserPreferenceArray;
import org.apache.mahout.cf.taste.impl.model.PlusAnonymousUserDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.PostgreSQLBooleanPrefJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by swara on 10/01/2017.
 */

@Service
public class GuestRecommendationLogServiceImpl implements GuestRecommendationService {
    @Autowired
    private DataSource dataSource;

    private final static Logger logger = LoggerFactory.getLogger(GuestRecommendationLogServiceImpl.class);

    public List<RecommendedItem> getGuestRecommendedItems(List<Long> items, double threshold, int howMany) {

        List<RecommendedItem> recommendedItemList = new ArrayList<>();
        try {
            recommendedItemList = getRecommendedItems(items, threshold, howMany);
        } catch (TasteException e) {
            logger.error("Taste Exception :" + e);
        }
        return recommendedItemList;
    }

    /**
     * @param items
     * @param threshold
     * @param howMany
     * @return
     * @throws TasteException
     */
    private List<RecommendedItem> getRecommendedItems(List<Long> items, double threshold, int howMany) throws TasteException {
        List<RecommendedItem> recommendedItems;
        DataModel model = getUserSkillsDataModel();
        PlusAnonymousUserDataModel plusAnonymousModel = new PlusAnonymousUserDataModel(model);

        UserSimilarity similarity = new LogLikelihoodSimilarity(plusAnonymousModel);
        UserNeighborhood neighborhood =
                new ThresholdUserNeighborhood(
                        threshold, similarity, model);
        Recommender recommender = new GenericBooleanPrefUserBasedRecommender(plusAnonymousModel,
                neighborhood, similarity);
        PreferenceArray anonymousPrefs =
                new BooleanUserPreferenceArray(items.size());
        anonymousPrefs.setUserID(0,
                PlusAnonymousUserDataModel.TEMP_USER_ID);
        int i;
        for (i = 0; i <= items.size(); i++) {
            anonymousPrefs.setItemID(i, items.get(i));
        }
        synchronized (anonymousPrefs) {
            plusAnonymousModel.setTempPrefs(anonymousPrefs);
            recommendedItems = recommender.recommend(PlusAnonymousUserDataModel.TEMP_USER_ID, howMany);
            plusAnonymousModel.clearTempPrefs();
        }
        return recommendedItems;
    }


    private DataModel getUserSkillsDataModel() {
        DataModel skillDataModel =
                new PostgreSQLBooleanPrefJDBCDataModel(dataSource, "userSkills", "userId", "skillId", null);
        return skillDataModel;
    }
}
