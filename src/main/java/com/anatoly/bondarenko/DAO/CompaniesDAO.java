package com.anatoly.bondarenko.DAO;

import com.anatoly.bondarenko.domain.Companies;
import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
public class CompaniesDAO extends GenericDAO <Companies> {

    @Override
    protected String createQueryForUpdate(Long id, Companies companies) {
        return String.format("UPDATE companies SET company_name = '%s' WHERE id = '%d'", companies.getCompanyName(), id);
    }


    @Override
    protected String createQuery(Companies companies) {
        return String.format("INSERT INTO companies (id, company_name) VALUES ('%s', '%s')", companies.getId(), companies.getCompanyName());
    }


    @Override
    protected List<Companies> convertToList(ResultSet resultSet) {
        List<Companies> companies = new ArrayList<>();
        try {
            while (resultSet.next()){
                Companies companyEntity = new Companies();  //  Пустой конструктор.  Получается, поля будут не заполнены (на этом этапе).
                //  Далее поля заполняются через сеттеры в обязательном порядке.
                companyEntity.setId(resultSet.getLong("id"));
                companyEntity.setCompanyName(resultSet.getString("company_name"));
                companies.add(companyEntity);
            }
        }
        catch (SQLException exception){
            logger.info("Exeption SQL: {}", exception.getMessage());
        }

        return companies;
    }





    @Override
    protected String getTableName() {
        return "companies";
    }


    @Override
    protected String getColumnId() {
        return "id";
    }



}
