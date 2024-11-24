package com.example.finalproject.Model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Credentionals {
    private String email;
    private String password;

    public Credentionals() {
    }

    public Credentionals(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credentionals{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
