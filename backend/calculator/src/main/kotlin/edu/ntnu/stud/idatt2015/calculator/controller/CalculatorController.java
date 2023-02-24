package edu.ntnu.stud.idatt2015.calculator.controller;
import edu.ntnu.stud.idatt2015.calculator.model.Equation;
import edu.ntnu.stud.idatt2015.calculator.services.CalculatorServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/calculations")
public class CalculatorController {

    private final CalculatorServices services = new CalculatorServices();
    Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

    @PostMapping(value = "/calc")
    public ResponseEntity<String> calculate(@RequestBody Equation exp){
        LOGGER.info("Received: " + exp.toString());
        if (exp.toString().isEmpty()) return ResponseEntity.noContent().build();
        String equation;
        try {
            services.solve(exp);
            equation = String.valueOf(services.toString());
        } catch (NumberFormatException e) {
            LOGGER.error("Error with expression format: " + e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Received error from calculation service " + e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        LOGGER.info("Sending Equation: " + equation);
        return ResponseEntity.ok(equation);
    }

    @GetMapping(value = "/ans")
    public ResponseEntity<Double> answer() {
        double ans = 0;
        try {
            ans = services.getAnswer();
        } catch (NullPointerException e) {
            LOGGER.error("Answer is null: " + e.getMessage());
        }
        LOGGER.info("Retrieved answer: " + services.getAnswer());
        return ResponseEntity.ok(ans);
    }
}

