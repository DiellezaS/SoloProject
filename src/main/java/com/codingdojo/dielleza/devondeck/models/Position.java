package com.codingdojo.dielleza.devondeck.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;



@Entity
@Table(name="positions")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="Enter a title!")
    @Size(min =1,  message = "Title must be at least 1 characters long")
    private String title;

    @NotEmpty(message="Job Description is needed")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "position_skills",
            joinColumns = @JoinColumn(name = "position_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> posSkills;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "applications",
            joinColumns = @JoinColumn(name = "position_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id"))
    private List<Developer> applicants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Skill> getPosSkills() {
        return posSkills;
    }

    public void setPosSkills(List<Skill> posSkills) {
        this.posSkills = posSkills;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<Developer> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Developer> applicants) {
        this.applicants = applicants;
    }


}