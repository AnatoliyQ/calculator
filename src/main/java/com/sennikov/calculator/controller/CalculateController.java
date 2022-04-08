package com.sennikov.calculator.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Api("Calculate controller")
@RestController
public class CalculateController {

    @ApiOperation(value = "Send add command")
    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public ResponseEntity<Integer> add(@RequestParam("firstNumber") int firstNumber, @RequestParam("secondNumber") int secondNumber) {
        return new ResponseEntity<>(firstNumber + secondNumber, HttpStatus.OK);
    }

    @ApiOperation(value = "Send minus command")
    @RequestMapping(path = "/minus", method = RequestMethod.GET)
    public ResponseEntity<Integer> minus(@RequestParam("firstNumber") int firstNumber, @RequestParam("secondNumber") int secondNumber) {
        return new ResponseEntity<>(firstNumber - secondNumber, HttpStatus.OK);
    }

    @ApiOperation(value = "Send multiply command")
    @RequestMapping(path = "/multiply", method = RequestMethod.GET)
    public ResponseEntity<Integer> multiply(@RequestParam("firstNumber") int firstNumber, @RequestParam("secondNumber") int secondNumber) {
        return new ResponseEntity<>(firstNumber * secondNumber, HttpStatus.OK);
    }

    @ApiOperation(value = "Send divide command")
    @RequestMapping(path = "/divide", method = RequestMethod.GET)
    public ResponseEntity<Long> divide(@RequestParam("firstNumber") int firstNumber, @RequestParam("secondNumber") int secondNumber) {
        try {
            return new ResponseEntity<>(((long) firstNumber / (long) secondNumber), HttpStatus.OK);
        } catch (ArithmeticException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}