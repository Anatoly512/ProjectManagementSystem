package com.anatoly.bondarenko;

import com.anatoly.bondarenko.DAO.*;
import com.anatoly.bondarenko.domain.Gender;
import com.anatoly.bondarenko.domain.SkillLevel;
import com.sun.jdi.InternalException;

import java.math.BigDecimal;
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
                String name = resultSet.getString("name");
                String genderString = resultSet.getString("gender");
                Gender gender = Gender.valueOf(genderString);
                int age = resultSet.getInt("age");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                System.out.println(String.format(" DEVELOPERS:  id = %d, name = %s, genger = %s, age = %s, salary = %s", id, name, gender, age, salary));
            }
        } catch (SQLException exception) {
            developersDAO.logger.error("Error occurred while getting entities. Exeption message: {}", exception.getMessage());
            throw new InternalException(String.valueOf(exception));
        }
        finally {
            System.out.println();
        }

    }


    public void displayCompanies(CompaniesDAO companiesDAO) {
        try {
            Connection connection;
            Statement statement;

            connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM companies");

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String companyName = resultSet.getString("company_name");
                System.out.println(String.format(" COMPANIES:  id = %d, company name = %s", id, companyName));
            }
        } catch (SQLException exception) {
            companiesDAO.logger.error("Error occurred while getting entities. Exeption message: {}", exception.getMessage());
            throw new InternalException(String.valueOf(exception));
        } finally {
            System.out.println();
        }

    }

        public void displayCustomers(CustomersDAO customersDAO) {
            try {
                Connection connection;
                Statement statement;

                connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
                statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");

                while (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    System.out.println(String.format(" CUSTOMERS:  id = %d, name = %s", id, name));
                }
            } catch (SQLException exception) {
                customersDAO.logger.error("Error occurred while getting entities. Exeption message: {}", exception.getMessage());
                throw new InternalException(String.valueOf(exception));
            }
            finally {
                System.out.println();
            }

    }


    public void displayProjects(ProjectsDAO projectsDAO) {
        try {
            Connection connection;
            Statement statement;

            connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM projects");

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String projectsName = resultSet.getString("projects_name");
                BigDecimal cost = resultSet.getBigDecimal("cost");
                System.out.println(String.format(" PROJECTS:  id = %d, projects name = %s, cost = %s", id, projectsName, cost));
            }
        } catch (SQLException exception) {
            projectsDAO.logger.error("Error occurred while getting entities. Exeption message: {}", exception.getMessage());
            throw new InternalException(String.valueOf(exception));
        } finally {
            System.out.println();
        }

    }


    public void displaySkills(SkillsDAO skillsDAO) {
        try {
            Connection connection;
            Statement statement;

            connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM skills");

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String language = resultSet.getString("language");
                String levelString = resultSet.getString("level");
                SkillLevel level = SkillLevel.valueOf(levelString);
                System.out.println(String.format(" SKILLS:  id = %d, language = %s, level = %s", id, language, level));
            }
        } catch (SQLException exception) {
            skillsDAO.logger.error("Error occurred while getting entities. Exeption message: {}", exception.getMessage());
            throw new InternalException(String.valueOf(exception));
        }
        finally {
            System.out.println();
        }

    }


}
