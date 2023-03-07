package edu.ntnu.stud.idatt2015.calculator.model;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bruker")
public class Users {

    @Id
    @Column(name = "username", unique = true, nullable = false)
    @NonNull
    private String username;
    @Column(name = "password", nullable = false)
    @NonNull
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="username", referencedColumnName = "username")
    private List<Equation> equations;

    public Users() {
    }

    public Users(@NotNull String username, @NotNull String password) {
        this.username = username;
        this.password = password;
    }

    public Users(@NonNull String username, @NonNull String password, List<Equation> equations) {
        this.username = username;
        this.password = password;
        this.equations = equations;
    }

    public void addEquation(@NonNull Equation equation) throws NullPointerException {
        equations.add(equation);
    }

    public void removeEquation(@NonNull Equation equation) throws NullPointerException {
        equations.remove(equation);
    }

    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }
}
