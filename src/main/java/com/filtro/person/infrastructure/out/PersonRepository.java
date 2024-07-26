package com.filtro.person.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.filtro.config.MySqlConfig;
import com.filtro.person.domain.enitty.Person;
import com.filtro.person.domain.service.PersonService;

public class PersonRepository implements PersonService{
    Connection connection = null;
    CallableStatement callableStatement = null;
    ResultSet resultSet = null;
    String response = null;


    @Override
    public String createPerson(Person person) {
        String sql = "{CALL create_person(?,?,?,?,?,?,?,?)}";
        try {
            // get connection
            connection = MySqlConfig.getConnection();
            // preapare call
            callableStatement = connection.prepareCall(sql);
            // set parameters
            callableStatement.setString(1, person.getName());
            callableStatement.setString(2, person.getLastName());
            callableStatement.setString(3, person.getCityName());
            callableStatement.setString(4, person.getAddress());
            callableStatement.setInt(5, person.getAge());;
            callableStatement.setString(6, person.getEmail());
            callableStatement.setInt(7, person.getIdGender());
            // register out parameter
            callableStatement.registerOutParameter(8, Types.VARCHAR);
            // call
            callableStatement.executeUpdate();
            // get response 
            response = callableStatement.getString(8);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return response;
    }

    @Override   
    public String deletePerson(int personId) {
        String sql = "{CALL delete_person(?,?)}";

        try {
            // get connection
            connection = MySqlConfig.getConnection();
            // preare call
            callableStatement = connection.prepareCall(sql);
            // parameters
            callableStatement.setInt(1, personId);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            // execute
            callableStatement.executeUpdate();
            // get repsonse
            response = callableStatement.getString(2);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return response;
    }

    @Override
    public String addSkillToPerson(java.util.Date registerDate, int personId, int skillId) {
        String sql = "{CALL add_skill_person(?,?,?,?)}";

        try {
            connection = MySqlConfig.getConnection();
            callableStatement = connection.prepareCall(sql);

            callableStatement.setDate(1, new Date((registerDate).getTime()));
            callableStatement.setInt(2, personId);
            callableStatement.setInt(3, skillId);
            callableStatement.registerOutParameter(4, Types.VARCHAR);

            callableStatement.executeUpdate();

            response = callableStatement.getString(4);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return response;
    }

    @Override
    public String updatePerson(Person person) {
        String sql = "{CALL update_person(?,?,?,?,?,?,?,?,?)}";

        try {
            connection = MySqlConfig.getConnection();
            callableStatement = connection.prepareCall(sql);

            callableStatement.setInt(1, person.getId());
            callableStatement.setString(2, person.getName());
            callableStatement.setString(3, person.getLastName());
            callableStatement.setString(4, person.getCityName());
            callableStatement.setString(5, person.getAddress());
            callableStatement.setInt(6, person.getAge());
            callableStatement.setString(7, person.getEmail());
            callableStatement.setInt(8, person.getIdGender());
            callableStatement.registerOutParameter(9, Types.VARCHAR);

            callableStatement.executeUpdate();

            response = callableStatement.getString(9);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return response;
    }

    @Override
    public List<Person> getPersonsBySkill(String skillName) {
        String sql = "{CALL get_persons_by_skill(?)}";
        List<Person> persons = new ArrayList<>();

        try {
            connection = MySqlConfig.getConnection();
            callableStatement = connection.prepareCall(sql);

            callableStatement.setString(1, skillName);

            resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                Person newPerson = new Person();

                newPerson.setId(resultSet.getInt("id"));
                newPerson.setName(resultSet.getString("individuo"));
                newPerson.setGenderName(resultSet.getString("genero"));
                newPerson.setSkill(resultSet.getString("habilidad"));

                persons.add(newPerson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return persons;
    }
    
    private void closeResources() {
        try {
            if (connection != null) connection.close();
            if (callableStatement != null) callableStatement.close();
            if (resultSet != null) resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
