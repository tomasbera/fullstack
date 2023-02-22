package edu.ntnu.stud.idatt2015.calculator.services;

import org.springframework.stereotype.Service;
import edu.ntnu.stud.idatt2015.calculator.model.Expression;

import java.util.ArrayList;

@Service
public class CalculatorServices {

    private double answer;
    private Expression equation;
    private final ArrayList<String>  log = new ArrayList<>();

    public void solve(Expression equation){
        this.equation = equation;
        if(equation.getOperator() == '+'){
            answer = equation.getN1() + equation.getN2();
            return;
        }else if(equation.getOperator() == '-'){
            answer = equation.getN1() - equation.getN2();
            return;
        }else if(equation.getOperator() == '*'){
            answer = equation.getN1() * equation.getN2();
            return;
        }else if(equation.getOperator() == '/'){
            answer = equation.getN1() / equation.getN2();
            return;
        }
        answer = 0;
    }

    public double getAnswer() {
        return answer;
    }

    public String toString(){
        return equation.toString() + " = " + answer;
    }

    public boolean addToLog(String toAdd){
        if(log.size() == 0 || !toAdd.equals(log.get(log.size()-1))){
            log.add(toAdd);
            return true;
        }
        return false;
    }

    public ArrayList<String> getLog() {
        return log;
    }
}
