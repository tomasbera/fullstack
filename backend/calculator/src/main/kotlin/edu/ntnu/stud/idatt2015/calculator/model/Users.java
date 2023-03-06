package edu.ntnu.stud.idatt2015.calculator.model;

import javax.persistence.*;
@Entity
@Table(name = "bruker")
public class Users {
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public Users() {

    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
