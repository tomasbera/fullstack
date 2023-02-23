package edu.ntnu.stud.idatt2015.calculator.services;

import org.springframework.stereotype.Service;
import edu.ntnu.stud.idatt2015.calculator.model.Expression;

@Service
public class CalculatorServices {

    private double answer;
    private Expression equation;

    public void solve(Expression exp){
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

    public String getAnswer() {
        return String.valueOf(answer);
    }

    public String toString(){
        return equation.toString();
    }
}
