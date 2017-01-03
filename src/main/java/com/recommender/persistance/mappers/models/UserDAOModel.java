package com.recommender.persistance.mappers.models;

/**
 * Created by swara on 27/12/2016.
 */
public class UserDAOModel {
    private String firstName;
    private String lastName;
    private int skillId;

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserDAOModel(String firstName, String lastName, int skillId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skillId = skillId;
    }

    public UserDAOModel() {
    }
}
