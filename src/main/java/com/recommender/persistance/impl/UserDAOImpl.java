package com.recommender.persistance.impl;

import com.recommender.persistance.UserDAO;
import com.recommender.persistance.mappers.UserMapper;
import com.recommender.persistance.mappers.models.UserDAOModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by swara on 25/12/2016.
 */
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public final String CREATE_USER = "INSERT INTO users (firstname, lastname, userid ) VALUES (?, ?, ?)";
    public final String GET_USER = "SELECT * FROM public.users WHERE jobId = ?";

    @Override
    public int insertUser(int userID, List<Integer> skillId) {
        return 0;
    }

    @Override
    public List<UserMapper> getJob(int userID) {
        return null;
    }
}
