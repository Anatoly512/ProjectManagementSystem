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
public abstract class GenericDAO <K, ID> {

    public Logger logger = LoggerFactory.getLogger("Logger");

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public List<K> getAllEntities() {
        String query = "SELECT * FROM " + getTableName();
        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            return convertToList(resultSet);

        } catch (SQLException exception) {
            logger.error("Error occurred while getting all entities from table = {}. Exeption message: {}", getTableName(), exception.getMessage());
            throw new InternalException(String.valueOf(exception));
        }

    }


    protected abstract String createQueryForUpdate(Long id, K value);

    protected abstract String createQuery(K value);

    protected abstract List<K> convertToList(ResultSet resultSet);

    protected abstract String getTableName();

    protected abstract String getColumnId();


}
