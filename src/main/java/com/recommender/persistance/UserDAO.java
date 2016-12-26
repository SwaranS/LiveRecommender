package com.recommender.persistance;

import com.recommender.skills.model.Job;
import com.recommender.skills.model.User;

import java.util.List;

/**
 * Created by swara on 25/12/2016.
 */
public interface UserDAO {

    public int insertUser(int userID, List<Integer> skillId);

    public User getJob (int userID);
}
