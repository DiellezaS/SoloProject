package com.codingdojo.dielleza.devondeck.services;


import com.codingdojo.dielleza.devondeck.models.*;
import com.codingdojo.dielleza.devondeck.repositories.DeveloperRepository;
import com.codingdojo.dielleza.devondeck.repositories.OrganizationRepository;
import com.codingdojo.dielleza.devondeck.repositories.PositionRepository;
import com.codingdojo.dielleza.devondeck.repositories.SkillRepository;
import jakarta.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class MainService {

    @Autowired
    DeveloperRepository dRepo;

    @Autowired
    OrganizationRepository oRepo;

    @Autowired
    PositionRepository pRepo;

    @Autowired
    SkillRepository sRepo;

    public Organization findOrgById(Long id) {
        return oRepo.findById(id).orElse(null);
    }


    public List<Skill> findAllSkills() {
        return (List<Skill>) sRepo.findAll();
    }


    public Position savePosition(@Valid Position position) {
        return pRepo.save(position);
    }


    public Skill findSkill(Long id) {
        return sRepo.findById(id).orElse(null);
    }





    public Developer saveDev(Developer dev) {
        return dRepo.save(dev);
    }


    public Developer findDeveloper(Long id) {
        return this.dRepo.findById(id).orElse(null);
    }



    public List<Position> findAllPositions() {
        return (List<Position>) pRepo.findAll();
    }


    public List<Organization> findAllOrgs() {
        return (List<Organization>) oRepo.findAll();
    }


    public Position findPosition(Long id) {
        return pRepo.findById(id).orElse(null);
    }


    public List<Developer> findallDevelopers() {

        return (List<Developer>) dRepo.findAll();
    }

    public void addSkill(Developer dev, Skill skill){
        List<Skill> skills=dev.getMyskills();
        skills.add(skill);
        dRepo.save(dev);
}

    public void removeSkill(Developer dev, Skill skill){
        List<Skill> skills=dev.getMyskills();
        skills.remove(skill);
        dRepo.save(dev);
    }


        public Skill find(Long id){
            return sRepo.findById(id).orElse(null);
}


}