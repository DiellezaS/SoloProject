package com.codingdojo.dielleza.devondeck.services;


import com.codingdojo.dielleza.devondeck.models.Developer;
import com.codingdojo.dielleza.devondeck.models.Organization;
import com.codingdojo.dielleza.devondeck.models.Position;
import com.codingdojo.dielleza.devondeck.models.Skill;
import com.codingdojo.dielleza.devondeck.repositories.DeveloperRepository;
import com.codingdojo.dielleza.devondeck.repositories.OrganizationRepository;
import com.codingdojo.dielleza.devondeck.repositories.PositionRepository;
import com.codingdojo.dielleza.devondeck.repositories.SkillRepository;
import jakarta.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Developer createDev(Developer dev) {
        String hashed = BCrypt.hashpw(dev.getPassword(), BCrypt.gensalt());
        dev.setPassword(hashed);
        return dRepo.save(dev);
    }




    public void createOrg(@Valid Organization org) {

        String hashed = BCrypt.hashpw(org.getPassword(), BCrypt.gensalt());
        org.setPassword(hashed);
        oRepo.save(org);
    }



    public Organization findOrgByEmail(String email) {

        return oRepo.findByEmail(email);

    }


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


    public List<Skill> findLanguages() {
        return sRepo.findAllByLanguageContaining(true);
    }


    public Developer saveDev(Developer dev) {
        return dRepo.save(dev);
    }


    public Developer findDeveloper(Long id) {
        return dRepo.findById(id).orElse(null);
    }


    public  Developer findDeveloperByEmail(String email) {
        return dRepo.findByEmail(email);
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

}