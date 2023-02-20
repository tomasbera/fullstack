package edu.ntnu.stud.idatt2015.calculator.controller;

import edu.ntnu.stud.idatt2015.calculator.model.Equation;
import edu.ntnu.stud.idatt2015.calculator.services.CalculatorServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.beans.Expression;

@RestController
@CrossOrigin

public class CalculatorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

    @PostMapping("/CalcControl")
    @ResponseBody
    public ResponseEntity<String> calculate(@RequestBody Equation body) {
        String request = body.getEqu();
        String result;
        LOGGER.info("Received" + request);
        if (request == null) return ResponseEntity.noContent().build();
        try {
            result = new CalculatorServices().calculateEq(request);
            System.out.println(result);
        }catch (Exception e){
            LOGGER.error("Error with expression format: " + e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return null;
    }
}
