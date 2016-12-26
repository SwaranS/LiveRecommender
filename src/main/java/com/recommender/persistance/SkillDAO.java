package com.recommender.persistance;

import com.recommender.skills.model.Job;
import com.recommender.skills.model.Skill;

import java.util.List;

/**
 * Created by swara on 25/12/2016.
 */
public interface SkillDAO {

    public int insertSkill(int skillId, String skillName);

    public Skill getSkill (int skillId);
}
