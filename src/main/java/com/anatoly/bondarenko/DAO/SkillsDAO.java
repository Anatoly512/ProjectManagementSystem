package com.anatoly.bondarenko.DAO;

import com.anatoly.bondarenko.domain.SkillLevel;
import com.anatoly.bondarenko.domain.Skills;
import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
public class SkillsDAO extends GenericDAO <Skills> {

    @Override
    protected String createQueryForUpdate(Long id, Skills skills) {
        return String.format("UPDATE skills SET language = '%s', level = '%s' WHERE id = '%d'", skills.getLanguage(), skills.getSkillLevel(), id);
    }


    @Override
    protected String createQuery(Skills skills) {
        return String.format("INSERT INTO skills (id, language, level) VALUES ('%s', '%s', '%s')", skills.getId(), skills.getLanguage(), skills.getSkillLevel());
    }


    @Override
    protected List<Skills> convertToList(ResultSet resultSet) {
        List<Skills> skills = new ArrayList<>();
        try {
            while (resultSet.next()){
                Skills skillEntity = new Skills();       //  Пустой конструктор.  Получается, поля будут не заполнены (на этом этапе).
                                                         //  Далее поля заполняются через сеттеры в обязательном порядке.
                skillEntity.setId(resultSet.getLong("id"));
                skillEntity.setLanguage(resultSet.getString("language"));
                skillEntity.setSkillLevel(SkillLevel.valueOf(resultSet.getString("level").toUpperCase()));
                skills.add(skillEntity);
            }
        }
        catch (SQLException exception){
            logger.info("Exeption SQL: {}", exception.getMessage());
        }

        return skills;
    }



    @Override
    protected String getTableName() {
        return "skills";
    }


    @Override
    protected String getColumnId() {
        return "id";
    }



}
