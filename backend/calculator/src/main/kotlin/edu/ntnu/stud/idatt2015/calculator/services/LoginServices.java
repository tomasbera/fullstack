package edu.ntnu.stud.idatt2015.calculator.services;

import edu.ntnu.stud.idatt2015.calculator.model.Users;
import edu.ntnu.stud.idatt2015.calculator.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServices {

    @Autowired
    UserRepo userRepo;

    private Users loggedIn;

    public Users okLogin(String username){
        return userRepo.findByUsername(username);
    }

    public boolean login(Users login){
        Users _login = userRepo.findByUsername(login.getUsername());
        if(_login == null || !login.getPassword().equals(_login.getPassword())) {
            return false;
        }
        loggedIn = _login;
        return true;
    }

    public boolean checkLogin(Users login){
        Users _login = userRepo.findByUsername(login.getUsername());
        return _login != null && login.getPassword().equals(_login.getPassword());
    }

    public Users getLoggedIn() {
        return loggedIn;
    }
}
