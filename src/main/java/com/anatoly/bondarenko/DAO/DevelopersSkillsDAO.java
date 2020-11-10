package com.anatoly.bondarenko.DAO;

import com.anatoly.bondarenko.Main;
import com.anatoly.bondarenko.domain.Developers;
import com.anatoly.bondarenko.domain.Gender;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class DevelopersSkillsDAO {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    public List<Developers> findAllDevelopersByLanguage(String language){
        List<Developers> developers = new ArrayList<>();

        String queryForDevelopersByLanguage = String.format(" SELECT * FROM my_db.developers_skills ds inner join developers d on ds.developer_id = d.developers_id inner join skills s on ds.skill_id = s.Skills_id where s.name = '%s' ", language);

        try {
            connection = DriverManager.getConnection(Main.getURL(),Main.getUser(),Main.getPassword());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryForDevelopersByLanguage);

            while (resultSet.next()){
                Long id = resultSet.getLong("developer_id");
                String name = resultSet.getString("name");
                Gender gender = Gender.valueOf(resultSet.getString("gender").toUpperCase());
                Integer age = resultSet.getInt("age");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                developers.add(new Developers(id,name, gender,age,salary));
            }

            System.out.println(developers);   ///  remove to Main !!!

            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException exception){
            System.out.println("Error message : " + exception);
        }

        return developers;
    }

    public List<Developers> findAllDevelopersByLanguageLevel(String level){
        List<Developers> developers = new ArrayList<>();

        String queryForLanguageLevel = String.format("SELECT * FROM developers_skills ds inner join developers d on ds.developer_id = d.developers_id inner join skills s on ds.skill_id = s.Skills_id  where s.level = '%s' group by d.developers_id", level);

        try {
            connection = DriverManager.getConnection(Main.getURL(),Main.getUser(),Main.getPassword());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryForLanguageLevel);

            while (resultSet.next()){

                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Gender gender = Gender.valueOf(resultSet.getString("gender").toUpperCase());
                Integer age = resultSet.getInt("age");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                developers.add(new Developers(id, name, gender, age, salary));
            }

            System.out.println(developers);  ///  remove to Main !!!

            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException exception){
            System.out.println("Error message : " + exception);
        }

        return developers;
    }




}



