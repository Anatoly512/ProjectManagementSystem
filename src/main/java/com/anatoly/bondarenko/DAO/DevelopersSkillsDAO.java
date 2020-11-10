package com.anatoly.bondarenko.DAO;

import com.anatoly.bondarenko.Main;
import com.anatoly.bondarenko.domain.Developers;
import com.anatoly.bondarenko.domain.Gender;
import com.anatoly.bondarenko.domain.SkillLevel;
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

        String queryForDevelopersByLanguage = String.format(" SELECT * FROM developers_skills ds inner join developers d on ds.developers_id = d.id inner join skills s on ds.skills_id = s.id where s.language = '%s' ", language);
 //     System.out.println(queryForDevelopersByLanguage);

        try {
            connection = DriverManager.getConnection(Main.getURL(),Main.getUser(),Main.getPassword());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryForDevelopersByLanguage);

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Gender gender = Gender.valueOf(resultSet.getString("gender").toUpperCase());
                Integer age = resultSet.getInt("age");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                developers.add(new Developers(id, name, gender, age, salary));
            }

            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException exception){
            System.out.println("Error message : " + exception);
        }

        return developers;
    }

    public List<Developers> findAllDevelopersByLanguageLevel(SkillLevel skillLevel){
        List<Developers> developers = new ArrayList<>();
        String level = String.valueOf(skillLevel);

        String queryForDevelopersByLanguageLevel = String.format("SELECT * FROM developers_skills ds inner join developers d on ds.developers_id = d.id inner join skills s on ds.skills_id = s.id  where s.level = '%s' ORDER BY d.id;", level);
//      System.out.println(queryForDevelopersByLanguageLevel);

        try {
            connection = DriverManager.getConnection(Main.getURL(),Main.getUser(),Main.getPassword());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryForDevelopersByLanguageLevel);

            while (resultSet.next()){

                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Gender gender = Gender.valueOf(resultSet.getString("gender").toUpperCase());
                Integer age = resultSet.getInt("age");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                developers.add(new Developers(id, name, gender, age, salary));
            }

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



