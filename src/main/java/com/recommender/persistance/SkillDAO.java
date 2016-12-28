package com.recommender.persistance;

import com.recommender.persistance.mappers.models.SkillDAOModel;

/**
 * Created by swara on 25/12/2016.
 */
public interface SkillDAO {

    public int insertSkill(int skillId, String skillName);

    public SkillDAOModel getSkill (int skillId);
}
