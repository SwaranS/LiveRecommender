package com.recommender.models;

/**
 * Created by swara on 25/12/2016.
 */
public class User {
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

    public User(int userId, int skillId) {
        this.userId = userId;
        this.skillId = skillId;
    }

    public User() {
    }
}
