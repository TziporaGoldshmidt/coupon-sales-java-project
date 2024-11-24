package com.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Credentionals credentionals;

    @JsonBackReference
    @OneToMany(mappedBy = "company")
    private List<Cupon> lstCupons;

    public Company() {
    }

    public Company( String name, Credentionals credentionals) {
        this.name = name;
        this.credentionals = credentionals;
        this.lstCupons = new ArrayList<>();
    }

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

    public Credentionals getCredentionals() {
        return credentionals;
    }

    public void setCredentionals(Credentionals credentionals) {
        this.credentionals = credentionals;
    }

    public List<Cupon> getLstCupons() {
        return lstCupons;
    }

    public void setLstCupons(List<Cupon> lstCupons) {
        this.lstCupons = lstCupons;
    }
    public void addCupon(Cupon cupon){
        lstCupons.add(cupon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) && Objects.equals(name, company.name) && Objects.equals(credentionals, company.credentionals) && Objects.equals(lstCupons, company.lstCupons);
    }


    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credentionals=" + credentionals +
                ", lstCupons=" + lstCupons +
                '}';
    }
}
