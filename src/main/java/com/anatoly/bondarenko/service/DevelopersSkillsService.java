package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.DAO.DevelopersSkillsDAO;
import com.anatoly.bondarenko.domain.Developers;
import com.anatoly.bondarenko.domain.SkillLevel;

import java.util.List;

public class DevelopersSkillsService {

    private final DevelopersSkillsDAO developersSkillsDAO;


    public DevelopersSkillsService(DevelopersSkillsDAO developersSkillsDAO) {
        this.developersSkillsDAO = developersSkillsDAO;
    }


    public List<Developers> findAllDevelopersByLanguage(String language){
        return developersSkillsDAO.findAllDevelopersByLanguage(language);
    }

    public  List<Developers> findAllDevelopersByLanguageLevel(SkillLevel level){
        return developersSkillsDAO.findAllDevelopersByLanguageLevel(level);
    }



}
