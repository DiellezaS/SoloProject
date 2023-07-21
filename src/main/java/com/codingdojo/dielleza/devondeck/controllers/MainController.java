package com.codingdojo.dielleza.devondeck.controllers;

import java.util.ArrayList;
import java.util.List;


import com.codingdojo.dielleza.devondeck.models.*;
import com.codingdojo.dielleza.devondeck.services.DeveloperService;
import com.codingdojo.dielleza.devondeck.services.MainService;

import com.codingdojo.dielleza.devondeck.services.OrganizationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MainController {

    @Autowired
    MainService service;
    @Autowired
    DeveloperService dservice;
    @Autowired
    OrganizationService oservice;


    @GetMapping("/register")
    public String index1(Model model, @ModelAttribute("newDev") Developer newDev, HttpSession session) {
        Long loggedInUserId = (Long) session.getAttribute("userId");

        if (loggedInUserId != null) {
            return "redirect:/devskills";
        }
        model.addAttribute("newUser", new Developer());
        return "devSignup";
    }

    @GetMapping("/devlogin")
    public String index(Model model,
                        @ModelAttribute("newLogin") Developer newLogin, HttpSession session) {
        Long loggedInUserId = (Long) session.getAttribute("userId");

        if (loggedInUserId != null) {
            return "redirect:/devskills";

        }
        model.addAttribute("newLogin", new Login());
        return "devlogin";
    }


    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newDev") Developer newDev, BindingResult result,
                           Model model, HttpSession session) {
        dservice.register(newDev, result);
        if (result.hasErrors()) {
            model.addAttribute("newLogin", new Login());
            return "devSignup";
        }
        session.setAttribute("userId", newDev.getId());
        return "redirect:/devskills";
    }

    @PostMapping("/devlogin")
    public String login(@Valid @ModelAttribute("newLogin") Login newLogin, BindingResult result,
                        Model model, HttpSession session) {
        Developer dev = dservice.login(newLogin, result);

        if (result.hasErrors()) {
            model.addAttribute("newDev", new Developer());
            return "devlogin";
        }
        session.setAttribute("userId", dev.getId());
        return "redirect:/devskills";

    }


    @GetMapping("/orgsignup")
    public String index1(Model model, @ModelAttribute("newOrg") Organization newOrg, HttpSession session) {
        Long loggedInUserId = (Long) session.getAttribute("userId");

        if (loggedInUserId != null) {
            return "redirect:/orgdashboard";
        }
        model.addAttribute("newOrg", new Organization());
        return "OrgSignUp";
    }

    @GetMapping("/orglogin")
    public String index(Model model,
                        @ModelAttribute("loginNew") Organization loginNew, HttpSession session) {
        Long loggedInUserId = (Long) session.getAttribute("userId");

        if (loggedInUserId != null) {
            return "redirect:/orgdashboard";
        }
        model.addAttribute("loginNew", new Login());
        return "orglogin";
    }


    @PostMapping("/orgsignup")
    public String register(@Valid @ModelAttribute("newOrg") Organization newOrg, BindingResult result,
                           Model model, HttpSession session) {
        oservice.register(newOrg, result);
        if (result.hasErrors()) {
            model.addAttribute("loginNew", new Login());
            return "OrgSignUp";
        }
        session.setAttribute("userId", newOrg.getId());
        return "redirect:/orgdashboard";
    }

    @PostMapping("/orglogin")
    public String loginOrg(@Valid @ModelAttribute("loginNew") Login loginNew, BindingResult result,
                           Model model, HttpSession session) {
        Organization org = oservice.login(loginNew, result);

        if (result.hasErrors()) {
            model.addAttribute("newOrg", new Organization());
            return "orglogin";
        }
        session.setAttribute("userId", org.getId());
        return "redirect:/orgdashboard";
    }


    @GetMapping("/orgdashboard")
    public String orgdash(Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "orglogin";
        }
        Long userId = (Long) session.getAttribute("userId");
        Organization org = service.findOrgById(userId);
        List<Developer> devs = service.findallDevelopers();
        model.addAttribute("org", org);
        model.addAttribute("devs", devs);
        return "orgdashboard";
    }

    @GetMapping("/newPosition")
    public String newPosition(@ModelAttribute("position") Position pos, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        Organization org = service.findOrgById(userId);
        List<Skill> skills = service.findAllSkills();
        model.addAttribute("skills", skills);

        return "newPosition";
    }

    @PostMapping("/newPosition")
    public String createPosition(@Valid @ModelAttribute("position") Position position, BindingResult result,
                                 @RequestParam("posSkills") ArrayList<Long> skillz, HttpSession session, HttpServletRequest request) {

        Long userId = (Long) session.getAttribute("userId");
        Organization org = service.findOrgById(userId);
        position.setOrganization(org);
        ArrayList<Skill> skills = new ArrayList<Skill>();

        for (int i = 0; i < skillz.size(); i++) {
            Long d = skillz.get(i);
            Skill s = service.findSkill(d);
            skills.add(s);
        }

        System.out.println(skills);
        if (result.hasErrors()) {
            return "newPosition";
        }

        service.savePosition(position);
        return "redirect:/orgdashboard";
    }

    @GetMapping("/devskills")
    public String devskills(HttpSession session, Model model, @ModelAttribute("newS") Skill newS) {
        List<Skill> skills = service.findAllSkills();
        Long userId = (Long) session.getAttribute("userId");
        Developer dev1 = service.findDeveloper(userId);


        model.addAttribute("skills", skills);
        model.addAttribute("dev", dev1);
        return "devskill";
    }


    @PostMapping("/addskill")
    public  String addSkill(@ModelAttribute("newS") Skill newS,@RequestParam("skillname") Long skillname,HttpSession session){
        Long userId= (Long) session.getAttribute("userId");
        Developer developer1=service.findDeveloper(userId);

        Skill skill=service.findSkill(skillname);
        List<Skill>skills=developer1.getMyskills();

        if (developer1.getMyskills().contains(skill)){
            service.removeSkill(developer1,skill);
        }
        else {
            if (skills.size()<5){
                developer1.setMyskills(developer1.getMyskills());
                service.addSkill(developer1,skill);
            }
        }
//        developer1.setMyskills(developer1.getMyskills());
//        service.addSkill(developer1,skill);
        return "redirect:/devskills";
    }





    @PostMapping("/addBio")
    public String addSkills(@ModelAttribute("dev")Developer dev, HttpSession session){
        Developer developer= service.findDeveloper((Long) session.getAttribute("userId"));
        developer.setBiography(dev.getBiography());
        developer.setBiography(dev.getBiography());
//        developer.setMyskills(skillname);
        service.saveDev(developer);
        return "redirect:/devdashboard";
    }


    @GetMapping("/devdashboard")
    public String devdash(HttpSession session, Model model) {
        if (session.getAttribute("userId")==null){
            return "redirect:/logout";
        }
        Long userId = (Long) session.getAttribute("userId");
        Developer dev = service.findDeveloper(userId);
        model.addAttribute("dev", dev);
        List<Position> positions = service.findAllPositions();
        model.addAttribute("positions", positions);
        List<Organization> companies = service.findAllOrgs();
        model.addAttribute("orgs", companies);
        return "devdashboard";
    }

    @GetMapping("/organization/{id}")
    public String orgJobPortal(Model model, @PathVariable("id") Long id, HttpSession session) {
        Organization org = service.findOrgById(id);
        Long userId = (Long) session.getAttribute("userId");
        Developer dev = service.findDeveloper(userId);
        model.addAttribute("org", org);
        model.addAttribute("dev", dev);
        return "orgJobPortal";
    }

//    @GetMapping("/devtool")
//    public String devtools( Model model,HttpSession session) {
//        if (session.getAttribute("userId")==null){
//            return "redirect:/devlogin";
//        }
//        Long userId= (Long) session.getAttribute("userId");
//        Developer dev = service.findDeveloper(userId);
//        List<Skill> skills = service.findAllSkills();
//        List<Skill> frameworks = new ArrayList<Skill>();
//
//        model.addAttribute("dev", dev);
//        model.addAttribute("frameworks",frameworks);
//        return "devskill";
//    }


    @GetMapping("/position/{id}")
    public String position(@ModelAttribute("developer")Developer dev,Model model,@PathVariable("id")Long id,HttpSession session) {
        Position pos = service.findPosition(id);
        Long userId = (Long) session.getAttribute("userId");
        model.addAttribute("pos",pos);
        model.addAttribute("userId",userId);
        return"position";
    }

    @GetMapping("/apply/{id}")
    public String apply(@PathVariable("id")Long id,HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");

        Position pos = service.findPosition(id);

        Developer dev = service.findDeveloper(userId);
        List<Position> applications = dev.getApplications();
        applications.add(pos);
        dev.setApplications(applications);
        service.saveDev(dev);
        return"redirect:/devdashboard";
    }

    @GetMapping("/applicants/{id}")
    public String myPosition(Model model,@PathVariable("id")Long id) {
        Position pos = service.findPosition(id);
        List<Developer> devs = service.findallDevelopers();

        model.addAttribute("pos",pos);
        model.addAttribute("devs",devs);
        return"positionApplicants";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/devlogin";
    }
}