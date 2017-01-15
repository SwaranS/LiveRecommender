package com.recommender.service;

import java.util.List;

/**
 * Created by swara on 14/01/2017.
 */
public interface SkillService {

    public long createSkill(String skillName);

    public void createMultipleSkills(List<String> skills);
}
