package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.DAO.DevelopersProjectsDAO;
import com.anatoly.bondarenko.domain.DevelopersProjects;

import java.util.List;

public class DevelopersProjectsService {

    private final DevelopersProjectsDAO developersProjectsDAO;


    public DevelopersProjectsService(DevelopersProjectsDAO developersProjectsDAO) {
        this.developersProjectsDAO = developersProjectsDAO;
    }


    public List<DevelopersProjects> findProjectAndAmountOfDevelopers(Long id) {
        return new DevelopersProjectsDAO().findProjectAndAmountOfDevelopers(id);

    }






}
