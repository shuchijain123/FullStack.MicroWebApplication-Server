package com.zipcode.wilmington.zipzapzopblog.controller;

import com.zipcode.wilmington.zipzapzopblog.model.Post;
import com.zipcode.wilmington.zipzapzopblog.repository.PostRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.Assert.*;
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)

public class PostControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostRepo repo;

    @Test
    public void index() {
    }

    @Test
    public void testShow() throws Exception{
        Long givenId = 1L;
        BDDMockito
                .given(repo.findById(givenId))
                .willReturn(Optional.of(new Post("New Post",null,null,null)));

        String expectedContent = "{\"id\":null,\"name\":\"New Post\",\"body\",\":null\",\"createDate\",\":null\",\"user\":null}";
        this.mvc.perform(MockMvcRequestBuilders
                .get("/posts/"+ givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testcreate() throws Exception {
        Post post = new Post("New Post",null,null,null);
        BDDMockito
                .given(repo.save(post))
                .willReturn(post);

        String expectedContent="{\"id\":null,\"name\":\"New Post\",\"body\",\":null\",\"createDate\",\":null\",\"user\":null}";
        this.mvc.perform(MockMvcRequestBuilders
                .post("/posts/")
                .content(expectedContent)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));

    }

    @Test
    public void update() {
    }

    @Test
    public void destroy() {
    }
}