package com.sennikov.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    public int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public int minus(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public double divide(int firstNumber, int secondNumber) {
        return (double) firstNumber / (double) secondNumber;
//        } catch (ArithmeticException ex) {
    }
}
