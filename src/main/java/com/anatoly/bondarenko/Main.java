package com.anatoly.bondarenko;

import com.anatoly.bondarenko.DAO.CompaniesDAO;
import com.anatoly.bondarenko.DAO.DevelopersDAO;
import com.anatoly.bondarenko.domain.Developers;
import com.anatoly.bondarenko.domain.Gender;
import com.anatoly.bondarenko.service.CompaniesService;
import com.anatoly.bondarenko.service.DevelopersService;
import com.sun.jdi.InternalException;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";

    static ShowTables showTables = new ShowTables();    //  Все представления данных вынесены в класс ShowTables

    public static void main(String[] args){

        DevelopersDAO developersDAO = new DevelopersDAO();
        CompaniesDAO companiesDAO = new CompaniesDAO();
        DevelopersService developersService = new DevelopersService(developersDAO);
        CompaniesService companiesService = new CompaniesService(companiesDAO);


        System.out.println("\n" + developersDAO.getAllEntities());               //  Тестовый вывод таблицы (через DAO)
        System.out.println("\n" + developersService.getAllDevelopers());          //  Тестовый вывод (через DevelopersService)
        System.out.println("\n" + companiesService.getAllCompanies() + "\n");     //  Тестовый вывод (через CompaniesService)

        //  Тестовый вывод таблиц в удобном виде
        showTables.displayDevelopers(developersDAO);
        showTables.displayCompanies(companiesDAO);



       //  Дональд Трамп кажется остался без работы

        //  Donald's interview
/*
        try {
            developersService.addNewDeveloper(new Developers(6L, "Trump Donald", Gender.MALE, 70));
            System.out.println("Welcome to go home, Donald!");
        }
         catch (InternalException exception) {
             System.out.println("Кажется, Дональд Трамп был уже принят на работу!");
         }
*/


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
