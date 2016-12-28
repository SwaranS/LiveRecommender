package com.recommender.service;

import com.recommender.persistance.impl.JobDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by swara on 28/12/2016.
 */
@Service
public class JobService {

    @Autowired
    private JobDAOImpl jobDAO;

    public int insertJob(int jobId, int skillId) {
        return jobDAO.insertJob(jobId, skillId);
    }
}
