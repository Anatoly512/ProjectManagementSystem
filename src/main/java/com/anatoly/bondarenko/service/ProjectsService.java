package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.DAO.ProjectsDAO;
import com.anatoly.bondarenko.domain.Projects;

import java.util.List;

public class ProjectsService {

    private final ProjectsDAO projectsDAO;


    public ProjectsService(ProjectsDAO projectsDAO) {
        this.projectsDAO = projectsDAO;
    }


    public List<Projects> getAllProjects() {

        return projectsDAO.getAllEntities();
    }


    public void deleteProject(Long id) {

        projectsDAO.deleteEntity(id);
    }


    public void addNewProject(Projects project) {

        projectsDAO.addNewEntity(project);
    }


    public void updateProject(Long id, Projects project) {

        projectsDAO.updateEntity(id, project);
    }



}
