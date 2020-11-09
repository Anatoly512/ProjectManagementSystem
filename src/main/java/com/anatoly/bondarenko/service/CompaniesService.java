package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.DAO.CompaniesDAO;
import com.anatoly.bondarenko.domain.Companies;

import java.util.List;

public class CompaniesService {


    private final CompaniesDAO companiesDAO;


    public CompaniesService(CompaniesDAO companiesDAO) {
        this.companiesDAO = companiesDAO;
    }


    public List<Companies> getAllCompanies() {

        return companiesDAO.getAllEntities();
    }


    public void deleteCompany(Long id) {

        companiesDAO.deleteEntity(id);
    }


    public void addNewCompany(Companies company) {

        companiesDAO.addNewEntity(company);
    }


    public void updateCompany(Long id, Companies company) {

        companiesDAO.updateEntity(id, company);
    }



}
