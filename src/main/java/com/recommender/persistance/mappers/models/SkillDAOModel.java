package com.recommender.persistance.mappers.models;

/**
 * Created by swara on 27/12/2016.
 */
public class SkillDAOModel {

    private int skillId;
    private String skillName;

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public SkillDAOModel(int skillId, String skillName) {
        this.skillId = skillId;
        this.skillName = skillName;
    }

    public SkillDAOModel() {
    }
}
