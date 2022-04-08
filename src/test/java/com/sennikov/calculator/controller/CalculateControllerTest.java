package com.sennikov.calculator.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class CalculateControllerTest {

    @Autowired
    private CalculateController calculateController;

    @Test
    public void test_add_numbers_test() {
        ResponseEntity<Integer> result = calculateController.add(10, 12);
        Assertions.assertEquals(22, result.getBody());
    }

    @Test
    public void test_minus_numbers_test() {
        ResponseEntity<Integer> result = calculateController.minus(40, 58);
        Assertions.assertEquals(-18, result.getBody());
    }


    @Test
    public void test_multiply_numbers_test() {
        ResponseEntity<Integer> result = calculateController.multiply(4, 5);
        Assertions.assertEquals(20, result.getBody());
    }

    @Test
    public void test_divide_numbers_positive_test() {
        ResponseEntity<Long> result = calculateController.divide(10, 5);
        Assertions.assertEquals(2, result.getBody());
    }

    @Test
    public void test_divide_by_zero_test() {
        ResponseEntity<Long> result = calculateController.divide(10, 0);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }
}
