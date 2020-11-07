package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.DAO.DevelopersDAO;
import com.anatoly.bondarenko.domain.Developers;

import java.util.List;


public class DevelopersService {

    private final DevelopersDAO developersDAO;


    public DevelopersService(DevelopersDAO developersDAO) {
        this.developersDAO = developersDAO;
    }



    public List<Developers> getAllDevelopers() {

        return developersDAO.getAllEntities();
    }


    public void deleteDeveloper(Long id) {

        developersDAO.deleteEntity(id);
    }


    public void addNewDeveloper(Developers developer) {

        developersDAO.addNewEntity(developer);
    }


    public void updateDeveloper(Long id, Developers developer) {

        developersDAO.updateEntity(id, developer);
    }



}
