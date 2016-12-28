package com.recommender.persistance.impl;

import com.recommender.persistance.JobDAO;
import com.recommender.persistance.mappers.models.JobDAOModel;

import java.util.List;

/**
 * Created by swara on 25/12/2016.
 */
public class JobDAOImpl implements JobDAO {
    @Override
    public int insertJob(int jobId, List<Integer> skillId) {
        return 0;
    }

    @Override
    public JobDAOModel getJob(int jobId) {
        return null;
    }
}
