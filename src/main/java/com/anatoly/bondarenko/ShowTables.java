package com.anatoly.bondarenko;

import com.anatoly.bondarenko.DAO.DevelopersDAO;
import com.anatoly.bondarenko.domain.Gender;
import com.sun.jdi.InternalException;

import java.sql.*;

public class ShowTables {

    public void displayDevelopers(DevelopersDAO developersDAO) {
        try {
            Connection connection;
            Statement statement;

            connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM developers");

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");;
                String genderString = resultSet.getString("gender");
                Gender gender = Gender.valueOf(genderString);
                int age = resultSet.getInt("age");
                System.out.println(String.format(" DEVELOPERS:  id = %d, name = %s, genger = %s, age = %s", id, name, gender, age));
            }
        } catch (SQLException exception) {
            developersDAO.logger.error("Error occurred while getting entities. Exeption message: {}", exception.getMessage());
            throw new InternalException(String.valueOf(exception));
        }

    }

}
