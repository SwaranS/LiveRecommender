package com.recommender.recommender;

import org.apache.mahout.cf.taste.impl.model.jdbc.PostgreSQLBooleanPrefJDBCDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * Created by swara on 03/01/2017.
 */
@Service
public class DBConnector {

    @Autowired
    private DataSource dataSource;

    public DataModel getUserSkillsDataModel(){
        DataModel skillDataModel =
                new PostgreSQLBooleanPrefJDBCDataModel(dataSource, "userSkills", "userId", "skillId", null);
        return skillDataModel;
    }
}
