package com.codingdojo.dielleza.devondeck.controllers;

import java.util.ArrayList;
import java.util.List;


import com.codingdojo.dielleza.devondeck.models.Developer;
import com.codingdojo.dielleza.devondeck.models.Organization;
import com.codingdojo.dielleza.devondeck.models.Position;
import com.codingdojo.dielleza.devondeck.models.Skill;
import com.codingdojo.dielleza.devondeck.services.MainService;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class MainController {

    @Autowired
    MainService service;

    @GetMapping("/devSignup")
    public String devSignUp(@ModelAttribute("developer") Developer dev) {
        return "devSignup";
    }

    @PostMapping("/newdev")
    public String newdev(@Valid @ModelAttribute("developer") Developer dev, BindingResult result, HttpSession session) {


        service.createDev(dev);
        session.setAttribute("devid", dev.getId());
        return "redirect:/devlogin";
    }

    @GetMapping("/orgSignup")
    public String orgSignUp(@ModelAttribute("organization") Organization org) {
        return "OrgSignUp";
    }

    @PostMapping("/newOrg")
    public String newOrg(@Valid @ModelAttribute("organization") Organization org, BindingResult result,
                         HttpSession session) {
        if (result.hasErrors()) {
            return "OrgSignUp";
        }
        service.createOrg(org);
        session.setAttribute("orgId", org.getId());
        return "redirect:/orgSignup";
    }

    @GetMapping("/devlogin")
    public String devlogin(@ModelAttribute("developer") Developer dev) {
        return "devlogin";
    }

    @PostMapping("/devlogin")
    public String devSignin(@Valid @ModelAttribute("developer") Developer dev, BindingResult result, Model model,
                            HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password) {

        dev = service.findDeveloperByEmail(email);
        if (session.getAttribute("devid") == null) {
            session.setAttribute("devid", dev.getId());
        }

        return "redirect:/devskills";
    }

    @GetMapping("/orglogin")
    public String orglogin(@ModelAttribute("organization") Organization org) {
        return "orglogin";
    }

    @PostMapping("/orglogin")
    public String orgSignin(@ModelAttribute("organization") Organization org, BindingResult result, Model model,
                            HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password) {

        org = service.findOrgByEmail(email);
        return "redirect:/orgdashboard";
    }

    @GetMapping("/devskills")
    public String devskills(@ModelAttribute("developer") Developer dev, HttpSession session, Model model) {
        List<Skill> skills = service.findAllSkills();
        List<Skill> langs = new ArrayList<Skill>();

        Developer dev1 = service.findDeveloper((Long) session.getAttribute("devid"));

        model.addAttribute("skills", skills);
        model.addAttribute("dev", dev1);
        System.out.println(dev1.getMyskills());
        return "devskill";
    }

    @GetMapping("/orgdashboard")
    public String orgdash(Model model, HttpSession session) {
        if (session.getAttribute("orgId") == null) {
            return "orglogin";
        }
        Long id = (Long) session.getAttribute("orgId");
        Organization org = service.findOrgById(id);
        List<Developer> devs = service.findallDevelopers();
        model.addAttribute("org", org);
        model.addAttribute("devs",devs);
        return "orgdashboard";
    }

    @GetMapping("/newPosition")
    public String newPosition(@ModelAttribute("position") Position pos, HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("orgId");
        Organization org = service.findOrgById(id);
        List<Skill> skills = service.findAllSkills();
        model.addAttribute("skills", skills);

        return "newPosition";
    }

    @PostMapping("/newPosition")
    public String createPosition(@Valid @ModelAttribute("position") Position position, BindingResult result,
                                 @RequestParam("posSkills") ArrayList<Long> skillz, HttpSession session, HttpServletRequest request) {

        Long id = (Long) session.getAttribute("orgId");
        Organization org = service.findOrgById(id);
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



    @PostMapping("/devtools/{id}")
    public String devtools(@Valid @ModelAttribute("developer") Developer dev, BindingResult result, HttpSession session,
                           Model model,@PathVariable("id")Long id) {
        if (result.hasErrors()) {
            return "devskill";
        }
        Developer dev1 = service.findDeveloper(id);
        List<Skill> dev1skills = dev1.getMyskills();

        List<Skill> skillist = dev.getMyskills();

        for(Skill s:skillist) {
            if(!dev1.getMyskills().contains(s)) {
                dev1skills.add(s);
            }
        }
        dev1.setBiography(dev.getBiography());
        dev1.setMyskills(dev1skills);
        dev.setMyskills(dev.getMyskills());
        service.saveDev(dev1);

        model.addAttribute("dev", dev);
        session.setAttribute("devid", dev1.getId());
        return "redirect:/devdashboard";
    }

    @GetMapping("/devdashboard")
    public String devdash(HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("devid");
        Developer dev = service.findDeveloper(id);
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
        Long devid = (Long) session.getAttribute("devid");
        Developer dev = service.findDeveloper(devid);
        model.addAttribute("org", org);
        model.addAttribute("dev", dev);
        return "orgJobPortal";
    }

    @GetMapping("/devtool/{id}")
    public String devtools(@PathVariable("id") Long id, @ModelAttribute("developer") Developer dev1, Model model) {

        Developer dev = service.findDeveloper(id);
        List<Skill> skills = service.findAllSkills();
        List<Skill> frameworks = new ArrayList<Skill>();

        model.addAttribute("dev", dev);
        model.addAttribute("frameworks",frameworks);
        return "devtool";

    }

    @PostMapping("/devtool/{id}")
    public String devFram(@Valid @ModelAttribute("developer") Developer dev, BindingResult result, HttpSession session,
                          Model model,RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "devskill";
        }
        service.saveDev(dev);
        System.out.println(dev.getId());
        System.out.println(dev.getMyskills());
        List<Skill> skills = service.findAllSkills();
        List<Skill> frameworks = new ArrayList<Skill>();

        System.out.println(dev.getId());
        model.addAttribute("dev", dev);
        session.setAttribute("devid", dev.getId());
        model.addAttribute("frameworks", frameworks);
        redirect.addAttribute("id",dev.getId());
        return "redirect:/devdashboard";
    }

    @GetMapping("/position/{id}")
    public String position(@ModelAttribute("developer")Developer dev,Model model,@PathVariable("id")Long id,HttpSession session) {
        Position pos = service.findPosition(id);
        Long devid = (Long) session.getAttribute("devid");
        model.addAttribute("pos",pos);
        model.addAttribute("devid",devid);
        return"position";
    }

    @GetMapping("/apply/{id}")
    public String apply(@PathVariable("id")Long id,HttpSession session) {
        Long devid = (Long) session.getAttribute("devid");

        Position pos = service.findPosition(id);

        Developer dev = service.findDeveloper(devid);
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
}