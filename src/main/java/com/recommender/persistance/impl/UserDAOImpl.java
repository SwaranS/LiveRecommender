package com.recommender.persistance.impl;

import com.recommender.persistance.UserDAO;
import com.recommender.persistance.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;
import java.util.List;

/**
 * Created by swara on 25/12/2016.
 */
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public final String CREATE_USER = "INSERT INTO users (firstname, lastname, userid ) VALUES (?, ?, ?)";
    public final String GET_USER = "SELECT * FROM public.users WHERE userId = ?";

    @Override
    public int insertUser(int userID, String firstName, String lastName) {
        Object[] params = {userID, firstName, lastName};
        int[] types = {Types.BIGINT, Types.VARCHAR, Types.VARCHAR};
        return jdbcTemplate.update(CREATE_USER, params, types);
    }

    @Override
    public List<UserMapper> getJob(int userID) {
        Object[] params = {userID};
        return jdbcTemplate.queryForList(GET_USER, params, UserMapper.class);
    }
}
