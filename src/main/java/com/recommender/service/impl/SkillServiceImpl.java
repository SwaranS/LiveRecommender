package com.recommender.service.impl;

import com.recommender.persistance.SkillDAO;
import com.recommender.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by swara on 14/01/2017.
 */
@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    @Qualifier("skillDAOImpl")
    private SkillDAO skillDAO;

    public long createSkill(String skillName) {
        return skillDAO.insertSkill(skillName);
    }

    @Cacheable(value="movieFindCache", key="#name")
    public void createMultipleSkills(List<String> skills) {
        skills.forEach(skill -> createSkill(skill));
    }

}
