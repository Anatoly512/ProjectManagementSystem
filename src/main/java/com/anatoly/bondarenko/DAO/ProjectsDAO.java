package com.anatoly.bondarenko.DAO;

import com.anatoly.bondarenko.domain.Projects;
import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProjectsDAO extends GenericDAO <Projects> {

    @Override
    protected String createQueryForUpdate(Long id, Projects projects) {
        return String.format("UPDATE projects SET projects_name = '%s', cost = '%s', date = '%s' WHERE id = '%d'", projects.getProjectsName(), projects.getCost(),  projects.getDate(), id);
    }


    @Override
    protected String createQuery(Projects projects) {
        return String.format("INSERT INTO projects (id, projects_name, cost, date) VALUES ('%s', '%s', '%s', '%s')", projects.getId(), projects.getProjectsName(), projects.getCost(), projects.getDate());
    }


    @Override
    protected List<Projects> convertToList(ResultSet resultSet) {
        List<Projects> projects = new ArrayList<>();
        try {
            while (resultSet.next()){
                Projects projectEntity = new Projects();  //  Пустой конструктор.  Получается, поля будут не заполнены (на этом этапе).
                                                          //  Далее поля заполняются через сеттеры в обязательном порядке.
                projectEntity.setId(resultSet.getLong("id"));
                projectEntity.setProjectsName(resultSet.getString("projects_name"));
                projectEntity.setCost(resultSet.getBigDecimal("cost"));
                projectEntity.setDate(resultSet.getDate("date"));
                projects.add(projectEntity);
            }
        }
        catch (SQLException exception){
            logger.info("Exeption SQL: {}", exception.getMessage());
        }

        return projects;
    }



    @Override
    protected String getTableName() {
        return "projects";
    }


    @Override
    protected String getColumnId() {
        return "id";
    }



}
