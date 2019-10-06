package com.dave.engle.fullstackreactredux.controllers;


import com.dave.engle.fullstackreactredux.services.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ProjectController.class)
class ProjectControllerTest {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ProjectService service;


    @Test
    void createNewProject() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/project")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andReturn();
    }
}
