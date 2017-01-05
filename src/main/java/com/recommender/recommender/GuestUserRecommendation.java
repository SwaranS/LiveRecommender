package com.recommender.recommender;

import org.apache.mahout.cf.taste.impl.model.BooleanUserPreferenceArray;
import org.apache.mahout.cf.taste.impl.model.GenericBooleanPrefDataModel;
import org.apache.mahout.cf.taste.impl.model.PlusAnonymousUserDataModel;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.util.List;

/**
 * Created by swara on 04/01/2017.
 * See http://stackoverflow.com/questions/13031726/the-use-of-plusanonymoususerdatamodel
 */

public class GuestUserRecommendation {

    public static void main(String[] args) throws Exception {
        DataModel model = new GenericBooleanPrefDataModel(
                GenericBooleanPrefDataModel.toDataMap(new FileDataModel(
                        new File(args[0]))));
        PlusAnonymousUserDataModel plusAnonymousModel = new PlusAnonymousUserDataModel(model);

        UserSimilarity similarity = new LogLikelihoodSimilarity(plusAnonymousModel);
        UserNeighborhood neighborhood =
                new NearestNUserNeighborhood(
                        Integer.parseInt(args[1]), similarity, plusAnonymousModel);
        //new ThresholdUserNeighborhood(Float.parseFloat(args[1]), similarity, model);


        System.out.println("Neighborhood=" + args[1]);
        System.out.println("");


        Recommender recommender = new GenericBooleanPrefUserBasedRecommender(model,
                neighborhood, similarity);


        PreferenceArray anonymousPrefs =
                new BooleanUserPreferenceArray(12);
        anonymousPrefs.setUserID(0,
                PlusAnonymousUserDataModel.TEMP_USER_ID);
        anonymousPrefs.setItemID(0, 1105L);
        anonymousPrefs.setItemID(1, 1201L);
        anonymousPrefs.setItemID(2, 1301L);
        anonymousPrefs.setItemID(3, 1401L);
        anonymousPrefs.setItemID(4, 1502L);
        anonymousPrefs.setItemID(5, 1602L);
        anonymousPrefs.setItemID(6, 1713L);
        anonymousPrefs.setItemID(7, 1801L);
        anonymousPrefs.setItemID(8, 1901L);
        anonymousPrefs.setItemID(9, 2002L);
        anonymousPrefs.setItemID(10, 9101L);
        anonymousPrefs.setItemID(11, 9301L);

        synchronized (anonymousPrefs) {
            plusAnonymousModel.setTempPrefs(anonymousPrefs);
            List<RecommendedItem> recommendations1 = recommender.recommend(PlusAnonymousUserDataModel.TEMP_USER_ID, 20);
            plusAnonymousModel.clearTempPrefs();

            System.out.println("Recm for anonymous:");

            for (RecommendedItem recommendation : recommendations1) {
                System.out.println(recommendation);
            }
            System.out.println("");
        }


        List<RecommendedItem> recommendations = recommender.recommend(
                Integer.parseInt(args[2]), 20);

        System.out.println("Recomedation for user_id="
                + Integer.parseInt(args[2]) + ":");

        for (RecommendedItem recommendation : recommendations) {
            System.out.println(recommendation);
        }
        System.out.println("");
    }
}
