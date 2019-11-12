package com.colwell.coding.swdocdata.controller;

import com.colwell.coding.swdocdata.entity.Project;
import com.colwell.coding.swdocdata.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/{project-id}")
    public Project getProjectByID(@PathVariable("project-id") String projectId) {
        return projectService.getByProjectId(projectId);
    }

    @PostMapping("/{project-name}")
    public Project createNewProject(@PathVariable("project-name") String projectName){
        return projectService.createNewProject(projectName);
    }

    @PutMapping
    public  Project updateProject(@RequestBody Project project){
        return projectService.updateProject(project);
    }
}

