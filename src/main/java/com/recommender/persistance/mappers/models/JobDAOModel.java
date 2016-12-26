package com.recommender.persistance.mappers.models;

import java.util.List;

/**
 * Created by swara on 26/12/2016.
 */
public class JobDAOModel {

    private int jobId;
    private int skillId;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public JobDAOModel() {
    }

    public JobDAOModel(int jobId, int skillId) {
        this.jobId = jobId;
        this.skillId = skillId;
    }
}
