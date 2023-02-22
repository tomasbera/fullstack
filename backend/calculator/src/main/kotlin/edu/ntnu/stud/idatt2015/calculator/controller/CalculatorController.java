package edu.ntnu.stud.idatt2015.calculator.controller;
import edu.ntnu.stud.idatt2015.calculator.model.Expression;
import edu.ntnu.stud.idatt2015.calculator.services.CalculatorServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/calculate")
public class CalculatorController {
    private final CalculatorServices services = new CalculatorServices();
    Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);


    @PostMapping(value = "/ans")
    public String answer(){
        LOGGER.info("Retrieved answer: " + services.getAnswer());
        return services.getAnswer();
    }

    @PostMapping(value = "/solve")
    public String solve(@RequestBody Expression expression){
        System.out.println(expression);
        services.solve(expression);
        LOGGER.info("Equation: n1: " + expression.getNumb1() +", n2: " +  expression.getNumb2()
                + ", operator: " + expression.getOperator());
        LOGGER.info("Answer: " + services.getAnswer());

        return services.toString();
    }
}

