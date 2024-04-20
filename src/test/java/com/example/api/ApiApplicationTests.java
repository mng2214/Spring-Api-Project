package com.example.api;

import com.springApi.ApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

// Corrected this line
@SpringBootTest(classes = ApiApplication.class)
@AutoConfigureMockMvc

public class ApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAllUsers() throws Exception {
        this.mockMvc.perform(get("/user/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetUser() throws Exception {
        this.mockMvc.perform(get("/user/1"))               // assuming there's a user with id = 1
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetUserNotPresent() throws Exception {
        this.mockMvc.perform(get("/user/-1"))              // assuming there's no user with id = -1
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}