package com.example.calculator.service;

import com.example.calculator.entity.Calculation;
import com.example.calculator.repository.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    private CalculationRepository repository;

    public Calculation calculate(double a, double b, String operation) {
        double result;
        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Divide by zero");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
        Calculation calc = new Calculation();
        calc.setOperand1(a);
        calc.setOperand2(b);
        calc.setOperation(operation);
        calc.setResult(result);
        calc.setTimestamp(LocalDateTime.now());
        repository.save(calc);
        return calc;
    }

    public List<Calculation> history() {
        return repository.findAll();
    }
}
