package com.zipcode.wilmington.zipzapzopblog.controller;

import com.zipcode.wilmington.zipzapzopblog.model.User;
import com.zipcode.wilmington.zipzapzopblog.repository.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.Mockito.mock;

public class RegistrationControllerTest {

    @Autowired
    private MockMvc mvc;


    @MockBean
    private UserRepo repository;

    @Test
    public void testRegistration() throws Exception{
        // Given
        HttpStatus expected = HttpStatus.CREATED;
        User expectedUser = new User("cw03@gmail.com", "1235","cw03","Charles","Wilmer");

        BDDMockito
                .given(repository.save(expectedUser))
                .willReturn(expectedUser);

        BDDMockito
                .given(repository.findByEmail(expectedUser.getEmail()))
                .willReturn(Optional.empty());
        BDDMockito
                .given(repository.findByUsername(expectedUser.getUsername()))
                .willReturn(Optional.empty());


        String expectedContent = "{\"id\":4,\"email\":\"cw03@gmail.com\",\"password\":\"1235\",\"username\":\"cw03\",\"firstName\":\"Charles\",\"lastName\":\"Wilmer\"}";


        this.mvc.perform(MockMvcRequestBuilders
                .post("/registration")
                .content(expectedContent)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
}
