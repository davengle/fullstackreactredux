package com.dave.engle.fullstackreactredux.services;

import com.dave.engle.fullstackreactredux.domain.Project;
import com.dave.engle.fullstackreactredux.repositories.ProjectRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProjectServiceTest {


    Project testProject;

    @InjectMocks
    ProjectService service;

    @Mock
    private ProjectRepository repository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);

        testProject = Project.builder().projectName("test Project")
                .description("Project under test")
                .startDate(LocalDate.now())
                .build();

    }

    @Test
    void saveOrUpdateProject() {
        when(repository.save(testProject)).thenReturn(testProject);
        Project returnedProject = service.saveOrUpdateProject(testProject);
        assertThat(returnedProject.getProjectName()).isEqualTo("test Project");

    }
}
