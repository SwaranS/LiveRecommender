package com.recommender.persistance;

import com.recommender.persistance.mappers.UserMapper;
import com.recommender.persistance.mappers.models.UserDAOModel;

import java.util.List;

/**
 * Created by swara on 25/12/2016.
 */
public interface UserDAO {

    public int insertUser(int userID, List<Integer> skillId);

    public List<UserMapper> getJob (int userID);
}
