package com.sennikov.calculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sennikov.calculator.dto.Response;
import com.sennikov.calculator.dto.iResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void when_execute_addition_then_ok() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/сalculation/addition")
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("firstNumber", "12")
                        .queryParam("secondNumber", "2"))
                .andExpect(status().isOk())
                .andReturn();

        iResponse expectedResponse = new Response<>(14);
        String responseMessage = result.getResponse().getContentAsString();
        assertEquals(objectMapper.writeValueAsString(expectedResponse), responseMessage);
    }

    @Test
    void when_execute_addition_then_overflow() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/сalculation/addition")
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("firstNumber", String.valueOf(Integer.MAX_VALUE))
                        .queryParam("secondNumber", "1"))
                .andExpect(status().isBadRequest())
                .andReturn();

        iResponse expectedResponse = new Response<>("Error. Too big numbers");
        String responseMessage = result.getResponse().getContentAsString();
        assertEquals(objectMapper.writeValueAsString(expectedResponse), responseMessage);
    }

    @Test
    void when_execute_subtraction_then_ok() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/сalculation/subtraction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("firstNumber", "120")
                        .queryParam("secondNumber", "34"))
                .andExpect(status().isOk())
                .andReturn();

        iResponse expectedResponse = new Response<>(86);
        String responseMessage = result.getResponse().getContentAsString();
        assertEquals(objectMapper.writeValueAsString(expectedResponse), responseMessage);
    }

    @Test
    void when_execute_subtraction_then_overflow() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/сalculation/subtraction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("firstNumber", String.valueOf(Integer.MIN_VALUE))
                        .queryParam("secondNumber", "1"))
                .andExpect(status().isBadRequest())
                .andReturn();

        iResponse expectedResponse = new Response<>("Error. Too big numbers");
        String responseMessage = result.getResponse().getContentAsString();
        assertEquals(objectMapper.writeValueAsString(expectedResponse), responseMessage);
    }

    @Test
    void when_execute_multiply_then_ok() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/сalculation/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("firstNumber", "12")
                        .queryParam("secondNumber", "3"))
                .andExpect(status().isOk())
                .andReturn();

        iResponse expectedResponse = new Response<>(36);
        String responseMessage = result.getResponse().getContentAsString();
        assertEquals(objectMapper.writeValueAsString(expectedResponse), responseMessage);
    }

    @Test
    void when_execute_multiply_then_overflow() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/сalculation/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("firstNumber", "554433")
                        .queryParam("secondNumber", "554433"))
                .andExpect(status().isBadRequest())
                .andReturn();

        iResponse expectedResponse = new Response<>("Error. Too big numbers");
        String responseMessage = result.getResponse().getContentAsString();
        assertEquals(objectMapper.writeValueAsString(expectedResponse), responseMessage);
    }

    @Test
    void when_execute_divide_then_ok() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/сalculation/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("firstNumber", "12")
                        .queryParam("secondNumber", "3"))
                .andExpect(status().isOk())
                .andReturn();

        iResponse expectedResponse = new Response<>(4.0);
        String responseMessage = result.getResponse().getContentAsString();
        assertEquals(objectMapper.writeValueAsString(expectedResponse), responseMessage);
    }

    @Test
    void when_execute_divide_by_zero_then_error() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/сalculation/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("firstNumber", "12")
                        .queryParam("secondNumber", "0"))
                .andExpect(status().isBadRequest())
                .andReturn();

        iResponse expectedResponse = new Response<>("Error. Division by zero");
        String responseMessage = result.getResponse().getContentAsString();
        assertEquals(objectMapper.writeValueAsString(expectedResponse), responseMessage);
    }
}
