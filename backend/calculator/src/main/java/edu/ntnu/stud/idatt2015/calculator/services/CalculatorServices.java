package edu.ntnu.stud.idatt2015.calculator.services;

import org.springframework.stereotype.Service;
import edu.ntnu.stud.idatt2015.calculator.model.Equation;

import java.util.ArrayList;

@Service
public class CalculatorServices {

    private double answer;
    private Equation equation;
    private final ArrayList<String> log = new ArrayList<>();

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

    public boolean addToLog(String toAdd){
        if(!toAdd.isEmpty()) {
            log.add(toAdd);
            return true;
        }
        return false;
    }

    public ArrayList<String> getLog() {
        return log;
    }
}
