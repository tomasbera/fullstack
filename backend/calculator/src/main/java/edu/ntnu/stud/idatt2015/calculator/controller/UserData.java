package edu.ntnu.stud.idatt2015.calculator.controller;

import edu.ntnu.stud.idatt2015.calculator.model.Equation;
import lombok.Data;
import java.util.List;

@Data
public class UserData {

    private String username;

    private String password;

    private List<Equation> calculations;
}