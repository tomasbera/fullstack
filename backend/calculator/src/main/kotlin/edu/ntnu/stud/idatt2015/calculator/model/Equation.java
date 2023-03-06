package edu.ntnu.stud.idatt2015.calculator.model;

import javax.persistence.*;

@Entity
@Table(name = "equation")
public class Equation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "numb1")
    private double numb1;
    @Column(name = "numb2")

    private double numb2;
    @Column(name = "operator")

    private char operator;
    @Column(name = "answer")
    private double answer;
    @ManyToOne
    @JoinColumn(name = "username")
    private Users user;

    public Equation() {
    }

    public Equation(int id, double numb1, double numb2, char operator, double answer, Users user) {
        this.id = id;
        this.numb1 = numb1;
        this.numb2 = numb2;
        this.operator = operator;
        this.answer = answer;
        this.user = user;
    }

    public Equation(Equation e) {
        this.id = e.id;
        this.numb1 = e.numb1;
        this.numb2 = e.numb2;
        this.operator = e.operator;
        this.answer = e.answer;
        this.user = e.user;
    }

    public Equation(double numb1, double numb2, char operator, double answer, Users user) {
        this.numb1 = numb1;
        this.numb2 = numb2;
        this.operator = operator;
        this.answer = answer;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public double getAnswer() {
        return answer;
    }

    public Users getUser() {
        return user;
    }

    public double getNumb1() {
        return numb1;
    }

    public void setNumb1(double numb1) {
        this.numb1 = numb1;
    }

    public double getNumb2() {
        return numb2;
    }

    public void setNumb2(double numb2) {
        this.numb2 = numb2;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return numb1 + " " + operator + " " + numb2 + " = " + answer;
    }

}
