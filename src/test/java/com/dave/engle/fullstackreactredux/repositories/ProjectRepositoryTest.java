package com.dave.engle.fullstackreactredux.repositories;

import com.dave.engle.fullstackreactredux.domain.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


@DataJpaTest
class ProjectRepositoryTest {

    @Autowired
    ProjectRepository repository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testSave(){
        Project testProject = Project.builder().projectName("test").build();
        repository.save(testProject);
        List<Project> projects = repository.findAll();
        assertThat(projects.size()).isEqualTo(1);
    }
}
