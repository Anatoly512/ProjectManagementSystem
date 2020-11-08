package com.anatoly.bondarenko.DAO;

import com.anatoly.bondarenko.domain.Developers;
import com.anatoly.bondarenko.domain.Gender;
import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
public class DevelopersDAO extends GenericDAO <Developers> {

    @Override
    protected String createQueryForUpdate(Long id, Developers developers) {
        return String.format("UPDATE developers SET name = '%s', gender = '%s', age = '%d' WHERE id = '%d'", developers.getName(), developers.getGender(), developers.getAge(), id);
    }


    @Override
    protected String createQuery(Developers developers) {
        return String.format("INSERT INTO developers (id, name, gender, age) VALUES ('%s', '%s', '%s', '%d')", developers.getId(), developers.getName(), developers.getGender(), developers.getAge());
    }


    @Override
    protected List<Developers> convertToList(ResultSet resultSet) {
        List<Developers> developers = new ArrayList<>();
        try {
            while (resultSet.next()){
                Developers developerEntity = new Developers();  //  Пустой конструктор.  Получается, поля будут не заполнены (на этом этапе).
                                                                //  Далее поля заполняются через сеттеры в обязательном порядке.
                developerEntity.setId(resultSet.getLong("id"));
                developerEntity.setName(resultSet.getString("name"));
                developerEntity.setGender(Gender.valueOf(resultSet.getString("gender").toUpperCase()));
                developerEntity.setAge(resultSet.getInt("age"));
                developers.add(developerEntity);
            }
        }
        catch (SQLException exception){
            logger.info("Exeption SQL: {}", exception.getMessage());
        }

        return developers;
    }





    @Override
    protected String getTableName() {
        return "developers";
    }


    @Override
    protected String getColumnId() {
        return "id";
    }



}
