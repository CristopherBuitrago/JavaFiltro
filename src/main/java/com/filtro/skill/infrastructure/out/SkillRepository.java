package com.filtro.skill.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.filtro.config.MySqlConfig;
import com.filtro.skill.domain.entity.Skill;
import com.filtro.skill.domain.service.SkillService;

public class SkillRepository implements SkillService{
    private Connection connection = null;
    private CallableStatement callableStatement = null;
    String response = null;

    @Override
    public String createSkill(Skill skill) {
        String sql = "{CALL create_skill(?,?)}";

        try {
            connection = MySqlConfig.getConnection();
            callableStatement = connection.prepareCall(sql);

            callableStatement.setString(1, skill.getName());
            callableStatement.registerOutParameter(2, Types.VARCHAR);

            callableStatement.executeUpdate();

            response = callableStatement.getString(2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return response;
    }

    private void closeResources() {
        try {
            if (connection != null) connection.close();
            if (callableStatement != null) callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
