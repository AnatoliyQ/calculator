package com.sennikov.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public int add(int firstNumber, int secondNumber) {
        return Math.addExact(firstNumber, secondNumber);
    }

    public int minus(int firstNumber, int secondNumber) {
        return Math.subtractExact(firstNumber, secondNumber);
    }

    public int multiply(int firstNumber, int secondNumber) {
        return Math.multiplyExact(firstNumber, secondNumber);
    }

    public double divide(int firstNumber, int secondNumber) {
        return (double) firstNumber / (double) secondNumber;
    }
}
