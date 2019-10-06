package com.dave.engle.fullstackreactredux.bootstrap;

import com.dave.engle.fullstackreactredux.domain.Project;
import com.dave.engle.fullstackreactredux.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    Project project1, project2, project3;

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    public void loadData(){
        project1 = Project.builder().description("Default desc 1").projectIdentifier("ID001").projectName("Default name 1").build();
        projectRepository.save(project1);
        project2 = Project.builder().description("Default desc 2").projectIdentifier("ID002").projectName("Default name 2").build();
        projectRepository.save(project2);
        project3 = Project.builder().description("Default desc 3").projectIdentifier("ID003").projectName("Default name 3").build();
        projectRepository.save(project3);
    }
}
