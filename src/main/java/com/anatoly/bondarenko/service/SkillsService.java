package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.DAO.SkillsDAO;
import com.anatoly.bondarenko.domain.Skills;

import java.util.List;

public class SkillsService {

    private final SkillsDAO skillsDAO;


    public SkillsService(SkillsDAO skillsDAO) {
        this.skillsDAO = skillsDAO;
    }


    public List<Skills> getAllSkills() {

        return skillsDAO.getAllEntities();
    }


    public void deleteSkill(Long id) {

        skillsDAO.deleteEntity(id);
    }


    public void addNewSkill(Skills skill) {

        skillsDAO.addNewEntity(skill);
    }


    public void updateSkill(Long id, Skills skill) {

        skillsDAO.updateEntity(id, skill);
    }


}
