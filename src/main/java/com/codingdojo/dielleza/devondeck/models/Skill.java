package com.codingdojo.dielleza.devondeck.models;

import java.util.List;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name="skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="Skill needs a name")
    private String name;


    private String language;


    private String framework;


    private String devtool;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "developer_skills",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id"))
    private List<Skill> skilleddevs;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "position_skills",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id"))
    private List<Skill> skillsposition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public String getDevtool() {
        return devtool;
    }

    public void setDevtool(String devtool) {
        this.devtool = devtool;
    }

    public List<Skill> getSkilleddevs() {
        return skilleddevs;
    }

    public void setSkilleddevs(List<Skill> skilleddevs) {
        this.skilleddevs = skilleddevs;
    }

    public List<Skill> getSkillsposition() {
        return skillsposition;
    }

    public void setSkillsposition(List<Skill> skillsposition) {
        this.skillsposition = skillsposition;
    }




}