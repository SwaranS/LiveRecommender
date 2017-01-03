package com.recommender.persistance;

import com.recommender.persistance.mappers.UserMapper;

import java.util.List;

/**
 * Created by swara on 03/01/2017.
 */
public interface UserSkillDAO {

    public int insertUserSkill(int userID, int skillId);

    public List<Integer> getJob (int userID);
}
