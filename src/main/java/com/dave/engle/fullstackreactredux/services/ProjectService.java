package com.dave.engle.fullstackreactredux.services;

import com.dave.engle.fullstackreactredux.domain.Project;
import com.dave.engle.fullstackreactredux.exceptions.ProjectIdentifierException;
import com.dave.engle.fullstackreactredux.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
