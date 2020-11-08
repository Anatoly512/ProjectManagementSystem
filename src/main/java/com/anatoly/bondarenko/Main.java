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


    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";



    public static void main(String[] args){

        DevelopersDAO developersDAO = new DevelopersDAO();
        System.out.println("\n" + developersDAO.getAllEntities());   //  Тестовый вывод

        DevelopersService developersService = new DevelopersService(developersDAO);
        System.out.println("\n" + developersService.getAllDevelopers() + "\n");      //  Тестовый вывод (через DevelopersService)

        //  Тестовый вывод всей таблицы developers
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

        //  Donald's interview
        try {
            developersService.addNewDeveloper(new Developers(6L, "Trump Donald", Gender.MALE, 70));
            System.out.println("Welcome to go home, Donald!");
        }
         catch (InternalException exception) {
             System.out.println("Кажется, Дональд Трамп был уже принят на работу!");
         }

        //  You're fired, Donald Trump!
/*
        try {
            developersService.deleteDeveloper(6L);
            System.out.println("You're fired, Donald Trump!");
        }
        catch (InternalException exception) {
            System.out.println("Его фиг уволишь! :)");
            System.out.println("Впрочем, возможно такого работника у нас и не было.");
        }
*/


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
