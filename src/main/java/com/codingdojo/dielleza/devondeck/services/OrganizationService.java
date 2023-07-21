package com.codingdojo.dielleza.devondeck.services;


import com.codingdojo.dielleza.devondeck.models.Login;
import com.codingdojo.dielleza.devondeck.models.Organization;
import com.codingdojo.dielleza.devondeck.repositories.OrganizationRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository oRepo;

    public Organization register(Organization newOrg, BindingResult result){
        Optional<Organization> potentionalUser=this.oRepo.findByEmail(newOrg.getEmail());

        //Email taken
        if (potentionalUser.isPresent()){
            result.rejectValue("email", "EmailTaken", "Email address is already in use!");
        }

        //Password doesn't match confirmation
        if (!newOrg.getPassword().equals(newOrg.getPassConfirm())){
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }

        //Return null if result has errors
        if (result.hasErrors()){
            return null;
        }

        //Save dev
        else{
            String hashed= BCrypt.hashpw(newOrg.getPassword(), BCrypt.gensalt());
            newOrg.setPassword(hashed);
            return oRepo.save(newOrg);
        }
    }

    public Organization login(Login newLogin, BindingResult result){
        Optional<Organization> potentionalUser=this.oRepo.findByEmail(newLogin.getEmail());

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
