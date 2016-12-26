package com.recommender.models;

/**
 * Created by swara on 19/12/2016.
 */

public class Skill {


    private int skillId;
    private String skillDescription;

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public Skill(int skillId, String skillDescription) {
        this.skillId = skillId;
        this.skillDescription = skillDescription;
    }

    public Skill() {
    }
}
