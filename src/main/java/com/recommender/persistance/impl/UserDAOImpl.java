package com.recommender.persistance.impl;

import com.recommender.persistance.UserDAO;
import com.recommender.persistance.mappers.models.UserDAOModel;

import java.util.List;

/**
 * Created by swara on 25/12/2016.
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public int insertUser(int userID, List<Integer> skillId) {
        return 0;
    }

    @Override
    public UserDAOModel getJob(int userID) {
        return null;
    }
}
