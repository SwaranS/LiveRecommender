package com.recommender.persistance;

import com.recommender.persistance.mappers.models.JobDAOModel;

import java.util.List;

/**
 * Created by swara on 25/12/2016.
 */
public interface JobDAO {

    public int insertJob(int jobId, List<Integer> skillId);

    public JobDAOModel getJob (int jobId);
}
