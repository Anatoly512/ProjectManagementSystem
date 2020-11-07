package com.anatoly.bondarenko;

import com.anatoly.bondarenko.DAO.DevelopersDAO;
import com.anatoly.bondarenko.domain.Developers;
import com.anatoly.bondarenko.domain.Gender;
import com.anatoly.bondarenko.service.DevelopersService;
import com.sun.jdi.InternalException;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.*;

@Data
@RequiredArgsConstructor
public class Main {


    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";



    public static void main(String[] args){

        DevelopersDAO developersDAO = new DevelopersDAO();
        System.out.println("\n" + developersDAO.getAllEntities());   //  Тестовый вывод

        DevelopersService developersService = new DevelopersService(developersDAO);
        System.out.println("\n" + developersService.getAllDevelopers() + "\n");      //  Тестовый вывод (через DevelopersService)

        //  Тестовый вывод всей таблицы postgres.developers
        try {
            Connection connection;
            Statement statement;

            connection = DriverManager.getConnection(getURL(), getUser(), getPassword());
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


    //  Дональд Трамп кажется остался без работы
        System.out.println("\n Entity: " + new Developers(6L,"Trump Donald", Gender.MALE, 70) + "\n");

        developersService.addNewDeveloper(new Developers(6L,"Trump Donald", Gender.MALE, 70));




    }



    public static String getURL() {
        return URL;
    }

    public static String getUser() {
        return USER;
    }

    public static String getPassword() {
        return PASSWORD;
    }

}
