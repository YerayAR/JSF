package com.example.calculator.web;

import com.example.calculator.entity.Calculation;
import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Scope("request")
public class CalculatorBean {

    private double operand1;
    private double operand2;
    private String operation = "+";
    private double result;
    private List<Calculation> history;

    @Autowired
    private CalculatorService service;

    @PostConstruct
    public void init() {
        history = service.history();
    }

    public String calculate() {
        try {
            Calculation calc = service.calculate(operand1, operand2, operation);
            result = calc.getResult();
            history = service.history();
        } catch (ArithmeticException | IllegalArgumentException e) {
            // Simple error handling: store negative sentinel value
            result = Double.NaN;
        }
        return null;
    }

    // Getters and setters
    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public List<Calculation> getHistory() {
        return history;
    }
}
