package com.example.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class HelloWorldTests {


    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public void testHello(){
        System.out.println("eeee");
//        mockMvc.perform(MockMvcRequestBuilders.get("helloworld").accept(MediaType.APPLICATION_JSON))
//                .andExpect()
//                .andExpect(conte)
    }

}
