package com.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    @JsonBackReference
    @OneToMany
    private List<Cupon> lstCupons;
    @Embedded
    private Credentionals credentionals;

    public Customer() {
    }

    public Customer(  String firstName, String lastName, Credentionals credentionals) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lstCupons = new ArrayList<>();
        this.credentionals = credentionals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


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

    public List<Cupon> getLstCupons() {
        return lstCupons;
    }

    public void setLstCupons(List<Cupon> lstCupons) {
        this.lstCupons = lstCupons;
    }

    public Credentionals getCredentionals() {
        return credentionals;
    }

    public void setCredentionals(Credentionals credentionals) {
        this.credentionals = credentionals;
    }
    public void addCupon(Cupon cupon){
        lstCupons.add(cupon);
    }



    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lstCupons=" + lstCupons +
                ", credentionals=" + credentionals +
                '}';
    }
}
