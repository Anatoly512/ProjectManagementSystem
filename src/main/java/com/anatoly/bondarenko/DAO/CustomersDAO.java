package com.anatoly.bondarenko.DAO;

import com.anatoly.bondarenko.domain.Customers;
import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
public class CustomersDAO extends GenericDAO <Customers> {

    @Override
    protected String createQueryForUpdate(Long id, Customers customers) {
        return String.format("UPDATE customers SET name = '%s' WHERE id = '%d'", customers.getName(), id);
    }


    @Override
    protected String createQuery(Customers customers) {
        return String.format("INSERT INTO customers (id, name) VALUES ('%s', '%s')", customers.getId(), customers.getName());
    }


    @Override
    protected List<Customers> convertToList(ResultSet resultSet) {
        List<Customers> customers = new ArrayList<>();
        try {
            while (resultSet.next()){
                Customers customerEntity = new Customers();  //  Пустой конструктор.  Получается, поля будут не заполнены (на этом этапе).
                                                             //  Далее поля заполняются через сеттеры в обязательном порядке.
                customerEntity.setId(resultSet.getLong("id"));
                customerEntity.setName(resultSet.getString("name"));
                customers.add(customerEntity);
            }
        }
        catch (SQLException exception){
            logger.info("Exeption SQL: {}", exception.getMessage());
        }

        return customers;
    }





    @Override
    protected String getTableName() {
        return "customers";
    }


    @Override
    protected String getColumnId() {
        return "id";
    }





}
