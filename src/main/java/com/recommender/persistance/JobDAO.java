package com.recommender.persistance;

import com.recommender.skills.model.Job;

import java.util.List;

/**
 * Created by swara on 25/12/2016.
 */
public interface JobDAO {

    public int insertJob(int jobId, List<Integer> skillId);

    public Job getJob (int jobId);
}
