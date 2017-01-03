package com.recommender.persistance;

import com.recommender.persistance.mappers.SkillMapper;
import com.recommender.persistance.mappers.models.SkillDAOModel;

import java.util.List;

/**
 * Created by swara on 25/12/2016.
 */
public interface SkillDAO {

    public int insertSkill(int skillId, String skillName);

    public List<SkillMapper> getSkill(int skillId);
}
