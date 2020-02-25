package com.api.electricitymanager.base.service;

import com.api.electricitymanager.base.dao.ProjectDAO;
import com.api.electricitymanager.base.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectService {

    private ProjectDAO projectDAO;

    @Autowired
    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Transactional
    public Project findById(int id) {
        return projectDAO.findById(id);
    }

    @Transactional
    public List<Project> findById(List<Integer> ids) {
        return projectDAO.findById(ids);
    }

    @Transactional
    public List<Project> findAll() {
        return projectDAO.findAll();
    }

    @Transactional
    public void save(Project project) {
        projectDAO.save(project);
    }

    @Transactional
    public  void deleteById(int id) {
        projectDAO.deleteById(id);
    }
}
