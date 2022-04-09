package com.sennikov.calculator.controller;

import com.sennikov.calculator.dto.Response;
import com.sennikov.calculator.dto.iResponse;
import com.sennikov.calculator.service.CalculateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("Calculate controller")
@RestController("api/v1/calculate")
public class CalculateController {

    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    private final CalculateService calculateService;

    @ApiOperation(value = "Send addition command")
    @RequestMapping(path = "/addition", method = RequestMethod.GET)
    public iResponse addition(@RequestParam("firstNumber") int firstNumber, @RequestParam("secondNumber") int secondNumber) {
        return new Response<>(calculateService.add(firstNumber, secondNumber));
    }

    @ApiOperation(value = "Send subtraction command")
    @RequestMapping(path = "/subtraction", method = RequestMethod.GET)
    public iResponse minus(@RequestParam("firstNumber") int firstNumber, @RequestParam("secondNumber") int secondNumber) {
        return new Response<>(calculateService.minus(firstNumber, secondNumber));
    }

    @ApiOperation(value = "Send multiply command")
    @RequestMapping(path = "/multiply", method = RequestMethod.GET)
    public iResponse multiply(@RequestParam("firstNumber") int firstNumber, @RequestParam("secondNumber") int secondNumber) {
        return new Response<>(calculateService.multiply(firstNumber, secondNumber));
    }

    @ApiOperation(value = "Send divide command")
    @RequestMapping(path = "/divide", method = RequestMethod.GET)
    public iResponse divide(@RequestParam("firstNumber") int firstNumber, @RequestParam("secondNumber") int secondNumber) {
        try {
            return new Response<>(calculateService.divide(firstNumber, secondNumber));
        } catch (ArithmeticException ex) {
            return new Response<>("Error. Division by zero");
        }
    }
}