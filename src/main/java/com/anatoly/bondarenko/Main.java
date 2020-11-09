package com.anatoly.bondarenko;

import com.anatoly.bondarenko.DAO.*;
import com.anatoly.bondarenko.domain.Developers;
import com.anatoly.bondarenko.domain.Gender;
import com.anatoly.bondarenko.service.*;
import com.sun.jdi.InternalException;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";

    static ShowTables showTables = new ShowTables();      //  Все представления данных вынесены в класс ShowTables

    private static final DevelopersDAO developersDAO = new DevelopersDAO();
    private static final CompaniesDAO companiesDAO = new CompaniesDAO();
    private static final CustomersDAO customersDAO = new CustomersDAO();
    private static final ProjectsDAO projectsDAO = new ProjectsDAO();
    private static final SkillsDAO skillsDAO = new SkillsDAO();
    private static final DevelopersService developersService = new DevelopersService(developersDAO);
    private static final CompaniesService companiesService = new CompaniesService(companiesDAO);
    private static final CustomersService customersService = new CustomersService(customersDAO);
    private static final ProjectsService projectsService = new ProjectsService(projectsDAO);
    private static final SkillsService skillsService = new SkillsService(skillsDAO);

    public static void main(String[] args){

        displayAllTablesTestSimpleView();  //  Тестовый вывод таблиц

        //  Тестовый вывод таблиц в удобном виде
        showTables.displayDevelopers(developersDAO);
        showTables.displayCompanies(companiesDAO);
        showTables.displayCustomers(customersDAO);
        showTables.displayProjects(projectsDAO);
        showTables.displaySkills(skillsDAO);




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



    public static void displayAllTablesTestSimpleView() {

        System.out.println("\n" + developersDAO.getAllEntities());         //  Тестовый вывод таблицы (через DAO)
        System.out.println("\n" + developersService.getAllDevelopers());    //  Тестовый вывод (через DevelopersService)
        System.out.println("\n" + companiesService.getAllCompanies());      //  Тестовый вывод (через CompaniesService)
        System.out.println("\n" + customersService.getAllCustomers());      //  Тестовый вывод (через CustomersService)
        System.out.println("\n" + projectsService.getAllProjects());        //  Тестовый вывод (через  ProjectsService)
        System.out.println("\n" + skillsService.getAllSkills() + "\n");     //  Тестовый вывод (через SkillsService)

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
