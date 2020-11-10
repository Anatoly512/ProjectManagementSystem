package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.DAO.DevelopersProjectsDAO;
import com.anatoly.bondarenko.domain.Developers;
import com.anatoly.bondarenko.domain.DevelopersProjects;

import java.sql.SQLException;
import java.util.List;

public class DevelopersProjectsService {

    private final DevelopersProjectsDAO developersProjectsDAO;


    public DevelopersProjectsService(DevelopersProjectsDAO developersProjectsDAO) {
        this.developersProjectsDAO = developersProjectsDAO;
    }


    public List<DevelopersProjects> findProjectAndAmountOfDevelopers(Long id) {
        return new DevelopersProjectsDAO().findProjectAndAmountOfDevelopers(id);

    }


    public List<Developers> findAllDevelopersOnTheProject(Long id) {
        return new DevelopersProjectsDAO().findAllDevelopersOfProject(id);
    }





}
