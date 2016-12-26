package com.recommender.models;

import java.util.List;

/**
 * Created by swara on 25/12/2016.
 */
public class Job {

    private int jobId;
    private List<Integer> skillId;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public List<Integer> getSkillId() {
        return skillId;
    }

    public void setSkillId(List<Integer> skillId) {
        this.skillId = skillId;
    }

    public Job(int jobId, List<Integer> skillId) {
        this.jobId = jobId;
        this.skillId = skillId;
    }

    public Job() {
    }
}
