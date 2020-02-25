package com.api.electricitymanager.base.rest;

import com.api.electricitymanager.base.entity.Project;
import com.api.electricitymanager.base.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectRestController {

    private ProjectService projectService;

    @Autowired
    public ProjectRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("")
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project findById(@PathVariable int id) {
        return projectService.findById(id);
    }

    @GetMapping("/list/{ids}")
    public List<Project> findById(@PathVariable List<Integer> ids) {
        return projectService.findById(ids);
    }

    @PostMapping("")
    public Project addProject(@RequestBody Project project) {
        projectService.save(project);
        return project;
    }

    @PutMapping("")
    public Project updateProject(@RequestBody Project project) {
        projectService.save(project);
        return project;
    }

    @DeleteMapping("/{id}")
    public Project deleteProject(@PathVariable int id) {
        Project oldProject = projectService.findById(id);
        projectService.deleteById(id);
        return oldProject;
    }
}
