package edu.ntnu.stud.idatt2015.calculator.services;

import org.springframework.stereotype.Service;
import edu.ntnu.stud.idatt2015.calculator.model.Equation;

@Service
public class CalculatorServices {

    private double answer;
    private Equation equation;

    public void solve(Equation exp){
        this.equation = exp;
        double numb1 = exp.getNumb1();
        double numb2 = exp.getNumb2();
        char op = exp.getOperator();
        this.answer = switch (op) {
            case '+' -> numb1 + numb2;
            case '-' -> numb1 - numb2;
            case '*' -> numb1 * numb2;
            case '/' -> numb1 / numb2;
            default -> 0;
        };
    }

    public Double getAnswer() {
        return answer;
    }

    public String toString(){
        return equation.toString();
    }
}
