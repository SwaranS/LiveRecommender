package com.recommender.persistance.mappers;

import com.recommender.persistance.mappers.models.UserDAOModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by swara on 27/12/2016.
 */
public class UserMapper implements RowMapper {
    @Override
    public UserDAOModel mapRow(ResultSet resultSet, int i) throws SQLException {
        return new UserDAOModel(resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getInt("userId"));
    }
}
