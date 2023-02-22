package edu.ntnu.stud.idatt2015.calculator.model;

public class Expression {
    private double numb1;
    private double numb2;
    private char operator;

    public double getNumb1() {
        return numb1;
    }

    public void setNumb1(int numb1) {
        this.numb1 = numb1;
    }

    public double getNumb2() {
        return numb2;
    }

    public void setNumb2(int numb2) {
        this.numb2 = numb2;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return numb1 + " " + operator + " " + numb2;
    }
}
