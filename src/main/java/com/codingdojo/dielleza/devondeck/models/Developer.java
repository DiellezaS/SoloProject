package com.codingdojo.dielleza.devondeck.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


import java.util.Date;
import java.util.List;


@Entity
@Table(name="developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required!")
    @Size(min = 2,max = 30, message = "First Name must be between 2 and 30 characters")
    private String fname;

    @NotBlank(message = "Last name is required!")
    @Size(min = 2,max = 30, message = "Last Name must be between 2 and 30 characters")
    private String lname;

    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;

    @NotEmpty(message = "Address is required!")
    private String address;

    @NotEmpty(message = "City is required!")
    private String city;

    @NotEmpty(message = "Please select a state")
    private String state;

    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;

    @Transient
    private String passConfirm;

    private String biography;

    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "developer_skills",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> myskills;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "applications",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id"))
    private List<Position> applications;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassConfirm() {
        return passConfirm;
    }

    public void setPassConfirm(String passConfirm) {
        this.passConfirm = passConfirm;
    }




    public List<Position> getApplications() {
        return applications;
    }

    public void setApplications(List<Position> applications) {
        this.applications = applications;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Skill> getMyskills() {
        return myskills;
    }

    public void setMyskills(List<Skill> myskills) {
        this.myskills = myskills;
    }


}