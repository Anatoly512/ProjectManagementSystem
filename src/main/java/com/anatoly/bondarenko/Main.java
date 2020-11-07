package com.anatoly.bondarenko;


import com.anatoly.bondarenko.DAO.DevelopersDAO;
import com.anatoly.bondarenko.service.DevelopersService;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Main {


    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";



    public static void main(String[] args){

        DevelopersDAO developersDAO = new DevelopersDAO();

        System.out.println("\n" + developersDAO.getAllEntities());


        DevelopersService developersService = new DevelopersService(developersDAO);

        System.out.println("\n" + developersService.getAllDevelopers());






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
