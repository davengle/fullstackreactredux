package com.dave.engle.fullstackreactredux.repositories;

import com.dave.engle.fullstackreactredux.domain.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


@DataJpaTest
class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository repository;

    @Autowired
    private EntityManager entityManager;

    Project testProject;

    @BeforeEach
    void setUp() {
        //Create valid project that passes all validation checks
        testProject = Project.builder().projectName("Test Project").startDate(LocalDate.now()).endDate(LocalDate.now().plusDays(1))
                .description("This is a test project").projectIdentifier("IDTE").build();
    }

    @Test
    public void createdAtDateIsCurrentDay(){
        Project savedProject = repository.save(testProject);
        assertThat(savedProject.getCreated_At().toLocalDate()).isEqualTo(LocalDate.now());
    }

    @Test
    public void validProjectSavesToDatabase(){
        repository.save(testProject);
        List<Project> projects = repository.findAll();
        assertThat(projects.size()).isEqualTo(1);
    }

    @Test
    public void projectNameNotBlank(){
        testProject.setProjectName("");
        constraintViolationTest(testProject);
    }

    @Test
    public void projectIdentierNotBlank(){
        testProject.setProjectIdentifier("");
        constraintViolationTest(testProject);
    }

    @Test
    public void projectIdentierTooShort(){
        testProject.setProjectIdentifier("123");
        constraintViolationTest(testProject);
    }

    @Test
    public void projectIdentierTooLong(){
        testProject.setProjectIdentifier("123456");
        constraintViolationTest(testProject);
    }

    @Test
    public void descriptionNotBlank(){
        testProject.setProjectIdentifier("");
        constraintViolationTest(testProject);
    }

    private void constraintViolationTest(Project testProject) {
        assertThrows(ConstraintViolationException.class, () -> {
            repository.save(testProject);
            entityManager.flush();
        });
    }
}
