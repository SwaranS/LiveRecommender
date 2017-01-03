package com.recommender.persistance.mappers.models;

/**
 * Created by swara on 03/01/2017.
 */
public class UserSkillDAOModel {

    private int userId;
    private int skillId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public UserSkillDAOModel(int userId, int skillId) {
        this.userId = userId;
        this.skillId = skillId;
    }

    public UserSkillDAOModel() {
    }
}
