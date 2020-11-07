package com.anatoly.bondarenko.DAO;

import com.anatoly.bondarenko.Main;
import com.sun.jdi.InternalException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;


@Data
@RequiredArgsConstructor
public abstract class GenericDAO <K> {

    public Logger logger = LoggerFactory.getLogger("Logger");

    private Connection connection;
    private Statement statement;

    public List<K> getAllEntities() {
        String query = "SELECT * FROM " + getTableName();
        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            return convertToList(resultSet);

        } catch (SQLException exception) {
            logger.error("Error occurred while getting all entities from table = {}. Exeption message: {}", getTableName(), exception.getMessage());
            throw new InternalException(String.valueOf(exception));
        }

    }


    public void deleteEntity(Long id) {
        String query = "DELETE FROM `" + getTableName() + "` WHERE " + getColumnId() + " = " + id;
        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (SQLException exception) {
            logger.error("Error occurred while delete entity from table = {}. Exeption message: {}", getTableName(), exception.getMessage());
            throw new InternalException(String.valueOf(exception));
        }
    }

    public void addNewEntity(K value) {
        String query = createQuery(value);

        //  Тестовый вывод запроса в базу данных
            System.out.println(query + "\n");

        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (SQLException exception) {
            logger.error("Error occurred while add new entity to table = {} . Exeption message: {}", getTableName(), exception.getMessage());
            throw new InternalException(String.valueOf(exception));
        }
    }

    public void updateEntity(Long id, K value) {
        String query = createQueryForUpdate(id, value);
        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException exception) {
            logger.error("Error occurred while update entity to table = {} . Exeption message: {}", getTableName(), exception.getMessage());
            throw new InternalException(String.valueOf(exception));
        }
    }







    protected abstract String createQueryForUpdate(Long id, K value);

    protected abstract String createQuery(K value);

    protected abstract List<K> convertToList(ResultSet resultSet);

    protected abstract String getTableName();

    protected abstract String getColumnId();


}
