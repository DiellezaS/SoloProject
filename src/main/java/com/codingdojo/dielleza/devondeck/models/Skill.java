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

    private String images;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "developer_skills",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id"))
    private List<Developer> skilleddevs;

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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public List<Developer> getSkilleddevs() {
        return skilleddevs;
    }

    public void setSkilleddevs(List<Developer> skilleddevs) {
        this.skilleddevs = skilleddevs;
    }

    public List<Skill> getSkillsposition() {
        return skillsposition;
    }

    public void setSkillsposition(List<Skill> skillsposition) {
        this.skillsposition = skillsposition;
    }
}