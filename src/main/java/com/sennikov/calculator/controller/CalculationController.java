package com.sennikov.calculator.controller;

import com.sennikov.calculator.dto.Response;
import com.sennikov.calculator.dto.iResponse;
import com.sennikov.calculator.service.CalculationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("Calculate controller")
@RestController()
@RequestMapping("api/v1/сalculation")
public class CalculationController {

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    private final CalculationService calculationService;

    @ApiOperation(value = "Send addition command")
    @GetMapping(path = "/addition")
    public iResponse addition(@RequestParam("firstNumber") int firstNumber, @RequestParam("secondNumber") int secondNumber) {
        return new Response<>(calculationService.add(firstNumber, secondNumber));
    }

    @ApiOperation(value = "Send subtraction command")
    @GetMapping(path = "/subtraction")
    public iResponse minus(@RequestParam("firstNumber") int firstNumber, @RequestParam("secondNumber") int secondNumber) {
        return new Response<>(calculationService.minus(firstNumber, secondNumber));
    }

    @ApiOperation(value = "Send multiply command")
    @GetMapping(path = "/multiply")
    public iResponse multiply(@RequestParam("firstNumber") int firstNumber, @RequestParam("secondNumber") int secondNumber) {
        return new Response<>(calculationService.multiply(firstNumber, secondNumber));
    }

    @ApiOperation(value = "Send divide command")
    @GetMapping(path = "/divide")
    public iResponse divide(@RequestParam("firstNumber") int firstNumber, @RequestParam("secondNumber") int secondNumber) {
        if (secondNumber == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return new Response<>(calculationService.divide(firstNumber, secondNumber));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Response<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new Response<>("Error. Division by zero");
    }

    @ExceptionHandler(ArithmeticException.class)
    public Response<String> handleArithmeticException(ArithmeticException ex) {
        return new Response<>("Error. Too big numbers");
    }
}