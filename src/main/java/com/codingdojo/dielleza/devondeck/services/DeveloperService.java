package com.codingdojo.dielleza.devondeck.services;

import com.codingdojo.dielleza.devondeck.models.Developer;
import com.codingdojo.dielleza.devondeck.models.Login;
import com.codingdojo.dielleza.devondeck.repositories.DeveloperRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class DeveloperService {
    @Autowired
    private DeveloperRepository dRepo;

    public Developer register(Developer newDev, BindingResult result){
        Optional<Developer> potentionalUser=this.dRepo.findByEmail(newDev.getEmail());

        //Email taken
        if (potentionalUser.isPresent()){
            result.rejectValue("email", "EmailTaken", "Email address is already in use!");
        }

        //Password doesn't match confirmation
        if (!newDev.getPassword().equals(newDev.getPassConfirm())){
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }

        //Return null if result has errors
        if (result.hasErrors()){
            return null;
        }

        //Save dev
        else{
            String hashed= BCrypt.hashpw(newDev.getPassword(), BCrypt.gensalt());
            newDev.setPassword(hashed);
            return dRepo.save(newDev);
        }
    }
    public Developer login(Login newLogin, BindingResult result){
        Optional<Developer> potentionalUser=this.dRepo.findByEmail(newLogin.getEmail());

        //User doesn't exist
        if (!potentionalUser.isPresent()){
            result.rejectValue("email", "EmailNotFound", "No user found with that email address");
        }
        else {
            if (!BCrypt.checkpw(newLogin.getPassword(), potentionalUser.get().getPassword())){
                //BCrypt password match fails
                result.rejectValue("password", "Matches", "Invalid password");
            }
        }
        //Return null if result has errors
        if (result.hasErrors()){
            return null;
        }
        else {
            return potentionalUser.get();
        }
    }
}
