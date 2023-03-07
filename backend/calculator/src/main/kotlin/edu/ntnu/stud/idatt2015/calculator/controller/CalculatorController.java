package edu.ntnu.stud.idatt2015.calculator.controller;
import edu.ntnu.stud.idatt2015.calculator.model.Equation;
import edu.ntnu.stud.idatt2015.calculator.services.CalculatorServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/calculations")
public class CalculatorController {

    @Autowired
    private CalculatorServices services;
    Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

    @PostMapping(value = "/calc")
    public void calculate(@RequestBody Equation exp){
        LOGGER.info("Received: " + exp.toString());
        if (exp.toString().isEmpty()){
            LOGGER.error("The equation is empty or missing");
        }
        try {
            services.solve(exp);
        } catch (NumberFormatException e) {
            LOGGER.error("Error with expression format: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Received error from calculation service " + e.getMessage());
        }

        if(services.addToLog(services + " = " + services.getAnswer())){
            LOGGER.info("Added to log: " + services + " = " + services.getAnswer());
        }
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

    @GetMapping("/log")
    public ArrayList<String> log(){
        LOGGER.info("Returned log: " + services.toString());
        return services.getLog();
    }
}

