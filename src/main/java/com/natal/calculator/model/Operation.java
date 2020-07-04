package com.natal.calculator.model;

public enum Operation {
    ADDITION("Addition", " + "), SUBTRACTION("Subtraction", " - "), MULTIPLICATION("Multiplication", " * ");

    String value;
    String operator;

    Operation(String value, String operator) {
        this.value = value;
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public String getOperator() {
        return operator;
    }
}
