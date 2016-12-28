package com.recommender.persistance.mappers;

import com.recommender.models.Job;
import com.recommender.persistance.mappers.models.JobDAOModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by swara on 26/12/2016.
 */
public class JobMapper implements RowMapper {
    @Override
    public JobDAOModel mapRow(ResultSet resultSet, int i) throws SQLException {
        return new JobDAOModel(resultSet.getInt("jobId"),
                resultSet.getInt("skillId"));
    }
}
