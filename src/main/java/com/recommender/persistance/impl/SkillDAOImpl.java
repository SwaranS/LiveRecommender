package com.recommender.persistance.impl;

import com.recommender.persistance.SkillDAO;
import com.recommender.persistance.mappers.JobMapper;
import com.recommender.persistance.mappers.SkillMapper;
import com.recommender.persistance.mappers.models.SkillDAOModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.List;

/**
 * Created by swara on 25/12/2016.
 */
@Service
public class SkillDAOImpl implements SkillDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public final String CREATE_SKILL = "INSERT INTO skills (skillid, skillName ) VALUES (?, ?)";
    public final String GET_SKILLS = "SELECT * FROM public.skills WHERE skillId = ?";


    @Override
    public int insertSkill(int skillId, String skillName) {
        Object[] params = {skillId, skillName};
        int[] types = {Types.BIGINT, Types.VARCHAR};
        return jdbcTemplate.update(CREATE_SKILL, params, types);
    }

    @Override
    public List<SkillMapper> getSkill(int skillId) {
        Object[] params = {skillId};
        return jdbcTemplate.queryForList(GET_SKILLS, params, SkillMapper.class);
    }
}
