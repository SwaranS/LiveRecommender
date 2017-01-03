package com.recommender.persistance.impl;

import com.recommender.persistance.UserSkillDAO;
import com.recommender.persistance.mappers.UserMapper;
import com.recommender.persistance.mappers.UserSkillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;
import java.util.List;

/**
 * Created by swara on 03/01/2017.
 */
public class UserSkillDAOImpl implements UserSkillDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public final String CREATE_USER_SKILL = "INSERT INTO userskills (userId, skillId ) VALUES (?, ?)";
    public final String GET_USER_SKILLS = "SELECT skillId FROM public.userskills WHERE userId = ?";

    @Override
    public int insertUserSkill(int userId, int skillId) {
        Object[] params = {userId, skillId};
        int[] types = {Types.BIGINT, Types.BIGINT};
        return jdbcTemplate.update(CREATE_USER_SKILL, params, types);
    }

    @Override
    public List<Integer> getJob(int userID) {
        Object[] params = {userID};
        return jdbcTemplate.queryForList(GET_USER_SKILLS, params, UserSkillMapper.class);
    }
}
