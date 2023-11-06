package com.ivy.sanaa.art.application.model.entities;

import java.io.Serializable;

public class Artist implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String role; // Representing user roles, e.g., admin, customer, etc.

    public Artist() {}

    public Artist(Long id, String username, String password, String firstName, String lastName, String email, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    // Setters and Getters for firstName, lastName, email, and role
    // ...

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
    

