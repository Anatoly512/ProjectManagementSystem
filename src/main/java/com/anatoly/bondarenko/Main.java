package com.anatoly.bondarenko;

import com.anatoly.bondarenko.DAO.*;
import com.anatoly.bondarenko.domain.*;
import com.anatoly.bondarenko.service.*;
import com.sun.jdi.InternalException;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";

    static ShowTables showTables = new ShowTables();          //  Все представления данных вынесены в класс ShowTables

    private static final DevelopersDAO developersDAO = new DevelopersDAO();
    private static final CompaniesDAO companiesDAO = new CompaniesDAO();
    private static final CustomersDAO customersDAO = new CustomersDAO();
    private static final ProjectsDAO projectsDAO = new ProjectsDAO();
    private static final SkillsDAO skillsDAO = new SkillsDAO();
    private static final DevelopersSkillsDAO developersSkillsDAO = new DevelopersSkillsDAO();
    private static final DevelopersProjectsDAO developersProjectsDAO = new DevelopersProjectsDAO();
    private static final DevelopersService developersService = new DevelopersService(developersDAO);
    private static final CompaniesService companiesService = new CompaniesService(companiesDAO);
    private static final CustomersService customersService = new CustomersService(customersDAO);
    private static final ProjectsService projectsService = new ProjectsService(projectsDAO);
    private static final SkillsService skillsService = new SkillsService(skillsDAO);
    private static final DevelopersSkillsService developersSkillsService = new DevelopersSkillsService(developersSkillsDAO);
    private static final DevelopersProjectsService developersProjectsService = new DevelopersProjectsService(developersProjectsDAO);

    static ProgrammLanguages languages = new ProgrammLanguages();

    public static void main(String[] args) {

        displayAllTablesTestSimpleView();  //  Тестовый вывод таблиц

        //  Тестовый вывод таблиц в удобном виде
        showTables.displayDevelopers(developersDAO);
        showTables.displayCompanies(companiesDAO);
        showTables.displayCustomers(customersDAO);
        showTables.displayProjects(projectsDAO);
        showTables.displaySkills(skillsDAO);


        // список всех Java разработчиков
        showTables.displayEnities(developersSkillsService.findAllDevelopersByLanguage(languages.JAVA), "JAVA DEVELOPERS : ");


        // список всех middle разработчиков
        System.out.println();
        showTables.displayEnities(developersSkillsService.findAllDevelopersByLanguageLevel(SkillLevel.MIDDLE), "MIDDLE LEVEL DEVELOPERS : ");


        //  В таблице проектов (projects) под номером 4 должна идти "Support APS",  а разработчиков у этого проекта (amountsOfDevelopers) должно быть 4"
        developersProjectsService.findProjectAndAmountOfDevelopers(4L);


        //  Все разработчики проекта (передать id проекта в конструктор)
        showTables.displayEnities(developersProjectsService.findAllDevelopersOnTheProject(4L));


        // Все проекты в формате -  дата создания - название проекта - количество разработчиков на этом проекте
        showTables.displayAllEnitiesWithDate(developersProjectsService.findAllProjectsAndItsAmountOfDevelopers());



       //  Дональд Трамп кажется остался без работы

        //  Donald's interview
/*
        try {
            developersService.addNewDeveloper(new Developers(6L, "Trump Donald", Gender.MALE, 70, new BigDecimal(1800)));
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


        //  Основываем новую компанию

/*        try {
            companiesService.addNewCompany(new Companies(6L, "company Corporation"));
            System.out.println("OK!");
        }
        catch (InternalException exception) {
            System.out.println("Что-то не получилось!");
        }

*/


        //  Закрываем компанию

/*        try {
            companiesService.deleteCompany(6L);
            System.out.println("Хорошая была компания... ");
        }
        catch (InternalException exception) {
            System.out.println("Какая у них крыша!.. Не закрывается! :)");
            System.out.println("Впрочем, возможно такой компании и не было.");
        }
*/



       //  Открываем новый проект
/*
        try {

            String dateString = "20-10-11";
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            Date d1 = df.parse(dateString);

            projectsService.addNewProject(new Projects(6L, "Project WOW", new BigDecimal(5000), d1));
            System.out.println("OK!");
        }
        catch (InternalException | ParseException exception) {
            System.out.println("Что-то не получилось!");
        }

*/

        //  Закрываем проект
/*

        try {
            projectsService.deleteProject(6L);
            System.out.println("Жалко... Хороший был проект.");
        }
        catch (InternalException exception) {
            System.out.println("Видимо, очень прибыльный :)  Не закрывается никак!");
        }

*/


        //  Находим нового клиента
/*
        try {
            customersService.addNewCustomer(new Customers(6L, "Bill Gates"));
            System.out.println("Ура!  У нас новый заказчик!");
        }
        catch (InternalException exception) {
            System.out.println("Заказчику что-то не понравилось... ((( ");
        }

*/


        //  Расторгаем договор с клиентом
/*

        try {
            customersService.deleteCustomer(6L);
            System.out.println("У нас этих заказчиков - завались!  Еще найдем!!!");
        }
        catch (InternalException exception) {
            System.out.println("Вот прилипучий... Не уходит!");
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
