package edu.ntnu.stud.idatt2015.calculator.repository;

import java.util.Optional;

import edu.ntnu.stud.idatt2015.calculator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User,String> {

    Optional<User> findByUsername(String username);
}