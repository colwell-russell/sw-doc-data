package com.colwell.coding.swdocdata.service;

import com.colwell.coding.swdocdata.entity.Project;
import com.colwell.coding.swdocdata.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project getByProjectId(String projectId){
        return projectRepository.findById(projectId).get();
    }

    public Project createNewProject(String projectName){
        Project project = new Project();
        project.setProjectName(projectName);
        project.setId(createProjectId());

        return projectRepository.save(project);
    }

    public Project updateProject(Project project){
        return projectRepository.save(project);
    }

    private String createProjectId(){
        return new Timestamp(System.currentTimeMillis()).toString();
    }
}
