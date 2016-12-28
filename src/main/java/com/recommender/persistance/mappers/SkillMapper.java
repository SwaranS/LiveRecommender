package com.recommender.persistance.mappers;

import com.recommender.persistance.mappers.models.SkillDAOModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by swara on 27/12/2016.
 */
public class SkillMapper implements RowMapper {
    @Override
    public SkillDAOModel mapRow(ResultSet resultSet, int i) throws SQLException {
        return new SkillDAOModel(resultSet.getInt("skillId"),
                resultSet.getString("skillName"));
    }
}
