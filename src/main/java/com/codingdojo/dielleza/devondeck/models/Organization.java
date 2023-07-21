package com.codingdojo.dielleza.devondeck.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;


@Entity
@Table(name="organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="Org Name Is Required!")
    @Size(min=3, max=30, message="Org Name must be between 2 and 30 characters")
    private String orgName;

    @NotEmpty(message="First Name Is Required!")
    @Size(min=3, max=30, message="First Name must be between 3 and 30 characters")
    private String fname;

    @NotEmpty(message="Last Name Is Required!")
    @Size(min=3, max=30, message="Last Name must be between 3 and 30 characters")
    private String lname;

    @NotEmpty(message="Email Is Require!")
    @Email(message="Please enter a valid email!")
    private String email;

    @NotEmpty(message="Valid Address is required!")
    @Size(min=2, max=128, message="Address must be between 2 and 128 characters")
    private String address;

    @NotEmpty(message = "City must be entered")
    private String city;

    @NotEmpty(message = "Please select a state")
    private String state;

    @NotEmpty(message = "password name must be entered")
    @Size(min = 8,  message = "password must be between at least 8 characters long")
    private String password;

    @Transient
    private String passConfirm;

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

    @OneToMany(mappedBy="organization",
            fetch = FetchType.LAZY)
    private List<Position> openPositions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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


    public List<Position> getOpenPositions() {
        return openPositions;
    }

    public void setOpenPositions(List<Position> openPositions) {
        this.openPositions = openPositions;
    }


}