package com.anatoly.bondarenko.service;


import com.anatoly.bondarenko.DAO.DevelopersDAO;
import com.anatoly.bondarenko.domain.Developers;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DevelopersService {

    private final DevelopersDAO developersDAO;


    public DevelopersService(DevelopersDAO developersDAO) {
        this.developersDAO = developersDAO;
    }

// Перегрузку конструктора потом убрать
    public DevelopersService(DevelopersDAO developersDAO, DevelopersDAO developersDAO1) {
        this.developersDAO = developersDAO1;
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
