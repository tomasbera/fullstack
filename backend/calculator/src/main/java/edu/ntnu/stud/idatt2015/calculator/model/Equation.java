package edu.ntnu.stud.idatt2015.calculator.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "equation")
public class Equation {
    @Id
    @GeneratedValue
    @Column(name = "equation_id", unique = true, nullable = false)
    private int id;
    @Column(name = "numb1", nullable = false)
    private double numb1;
    @Column(name = "numb2", nullable = false)

    private double numb2;
    @Column(name = "operator", nullable = false)
    private char operator;
    @Column(name = "answer", nullable = true)
    private double answer;
}
