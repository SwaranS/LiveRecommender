package com.recommender.evaluate;

import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;

import java.io.File;

/**
 * Created by Home on 17/03/2017.
 * http://kickstarthadoop.blogspot.ie/2011/05/evaluating-mahout-based-recommender.html
 */
public class SkillsEvaluator {

    public static void main(String[] args){

       /* DataModel model = new GroupLensDataModel (new File("ratings.dat"));
        RecommenderEvaluator evaluator =
                new AverageAbsoluteDifferenceRecommenderEvaluator();
        RecommenderBuilder recommenderBuilder = new RecommenderBuilder() {
            @Override
            public Recommender buildRecommender(
                    DataModel model) throws TasteException {
                UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
                UserNeighborhood neighborhood =
                        new NearestNUserNeighborhood(100, similarity, model);
                return new GenericUserBasedRecommender(
                        model, neighborhood, similarity);
            }
        };
        double score = evaluator.evaluate(
                recommenderBuilder, null, model, 0.95, 0.05);
        System.out.println(score);*/
    }
}
