package com.recommender.persistance.mappers;

import com.recommender.persistance.mappers.models.UserDAOModel;
import com.recommender.persistance.mappers.models.UserSkillDAOModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by swara on 03/01/2017.
 */
public class UserSkillDAOMapper implements RowMapper {

    @Override
    public UserSkillDAOModel mapRow(ResultSet resultSet, int i) throws SQLException {
        return new UserSkillDAOModel(resultSet.getInt("userId"), resultSet.getInt("skillId"));
    }
}
