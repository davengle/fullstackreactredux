package com.dave.engle.fullstackreactredux.services;

import com.dave.engle.fullstackreactredux.domain.Project;
import com.dave.engle.fullstackreactredux.exceptions.ProjectIdentifierException;
import com.dave.engle.fullstackreactredux.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;


    public Project saveOrUpdateProject(Project project){

        try {
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdentifierException("Project Identifier " + project.getProjectIdentifier().toUpperCase() + " already exists");
        }
    }

    public Project findProjectByIdentifier(String projectIdentifier){
        Project project = projectRepository.findByProjectIdentifier(projectIdentifier);
        if(project == null)
            throw new ProjectIdentifierException("Project " + projectIdentifier.toUpperCase() + " does not exist");
        return project;
    }

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String identifier){
        Project project = projectRepository.findByProjectIdentifier((identifier.toUpperCase()));
        if(project == null)
            throw new ProjectIdentifierException("Project with identifier " + identifier.toUpperCase() + " does not exist");

        projectRepository.delete(project);
    }

}
