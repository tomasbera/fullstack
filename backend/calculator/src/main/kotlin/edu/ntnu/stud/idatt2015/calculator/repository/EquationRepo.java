package edu.ntnu.stud.idatt2015.calculator.repository;

import edu.ntnu.stud.idatt2015.calculator.model.Equation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquationRepo extends JpaRepository<Equation, Integer> {

}
