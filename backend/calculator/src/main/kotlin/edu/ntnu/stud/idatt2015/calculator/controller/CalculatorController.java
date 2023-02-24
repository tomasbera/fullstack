package edu.ntnu.stud.idatt2015.calculator.controller;
import edu.ntnu.stud.idatt2015.calculator.model.Equation;
import edu.ntnu.stud.idatt2015.calculator.services.CalculatorServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/calculate")
public class CalculatorController {

    private final CalculatorServices services = new CalculatorServices();
    Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

    @PostMapping(value = "/solve")
    public String solve(@RequestBody Equation exp){
        services.solve(exp);
        LOGGER.info("Equation2: " + exp.getNumb1() +" "+ exp.getOperator() +" "+ exp.getNumb2());
        LOGGER.info("Answer: " + services.getAnswer());

        return services.toString();
    }

    @GetMapping(value = "/ans")
    public double answer(){
        LOGGER.info("Retrieved answer: " + services.getAnswer());
        return services.getAnswer();
    }
}

