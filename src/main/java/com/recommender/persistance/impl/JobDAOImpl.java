package com.recommender.persistance.impl;

import com.recommender.persistance.JobDAO;
import com.recommender.persistance.mappers.models.JobDAOModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

/**
 * Created by swara on 25/12/2016.
 */
@Service
public class JobDAOImpl implements JobDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public final String CREATE_JOB = "INSERT INTO jobs (skillid, jobid ) VALUES (?, ?)";
    public final String GET_JOBS = "SELECT * FROM public.jobs WHERE jobId = ?";

    @Override
    public int insertJob(int jobId, int skillId) {
        Object[] params = {jobId, skillId};
        int[] types = {Types.BIGINT, Types.BIGINT};
        return jdbcTemplate.update(CREATE_JOB, params, types);
    }

    @Override
    public List<JobDAOModel> getJob(int jobId) {
        return null;
    }
}
