package edu.ntnu.stud.idatt2015.calculator.services;

import org.springframework.stereotype.Service;
import edu.ntnu.stud.idatt2015.calculator.model.Equation;

@Service
public class CalculatorServices {

    private double answer;
    private Equation equation;

    public void solve(Equation exp){
        this.equation = exp;
        if(exp.getOperator() == '+'){
            answer = exp.getNumb1() + exp.getNumb2();
            return;
        }else if(exp.getOperator() == '-'){
            answer = exp.getNumb1() - exp.getNumb2();
            return;
        }else if(exp.getOperator() == '*'){
            answer = exp.getNumb1() * exp.getNumb2();
            return;
        }else if(exp.getOperator() == '/'){
            answer = exp.getNumb1() / exp.getNumb2();
            return;
        }
        answer = 0;
    }

    public double getAnswer() {
        return answer;
    }

    public String toString(){
        return equation.toString();
    }
}
