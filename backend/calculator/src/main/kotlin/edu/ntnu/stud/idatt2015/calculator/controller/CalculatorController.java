package edu.ntnu.stud.idatt2015.calculator.controller;
import edu.ntnu.stud.idatt2015.calculator.model.Expression;
import edu.ntnu.stud.idatt2015.calculator.services.CalculatorServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping("/calculate")
public class CalculatorController {


    private final CalculatorServices services = new CalculatorServices();
    Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);


    @GetMapping("/ans")
    public double answer(){
        LOGGER.info("Retrieved answer: " + services.getAnswer());
        return services.getAnswer();
    }

    @PostMapping("/solve")
    public double solve(@RequestBody Expression expression){
        services.solve(expression);
        LOGGER.info("Equation: n1: " + expression.getN1() +", n2: " +  expression.getN2()
                + ", operator: " + expression.getOperator());
        LOGGER.info("Answer: " + services.getAnswer());

        if (services.addToLog(services.toString())){
            LOGGER.info("Added to : " + services.toString());
        }
        return services.getAnswer();
    }

    @GetMapping("/log")
    public ArrayList<String> log() {
        LOGGER.info("Return log: " + services.toString());
        return services.getLog();
    }
}

