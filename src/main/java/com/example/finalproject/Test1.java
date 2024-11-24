package com.example.finalproject;

import com.example.finalproject.Model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class Test1 implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;

    Company company1=new Company("ABC",new Credentionals("ABC@gmail.com","123"));
    Company company2=new Company("ABC",new Credentionals("EFG@gmail.com","456"));
    Customer cust=new Customer("Meir","kohen",new Credentionals("m12345@gmail.com","12345"));
    Cupon cupon1=new Cupon(company1,cust, Category.Food,"מבצע מיוחד","happy birthdate", LocalDate.of(2021,2,8),LocalDate.of(2021,3,8),80,100,"ASAA");
    Cupon cupon2=new Cupon(company2,cust,Category.Electricity,"כל הקודם זוכה","happy DAY", LocalDate.of(2024,6,4),LocalDate.of(2024,7,4),50,50,"JFJF");
    List<Cupon> lst=new ArrayList<>();

    public void addCustomer(){
        lst.add(cupon1);
        lst.add(cupon2);
        Customer customer=new Customer("Yeuda","Shimoni",new Credentionals("y1267@gmail.com","8712"));
        entityManager.persist(company1);
        entityManager.persist(company2);
        entityManager.persist(cupon1);
        entityManager.persist(cupon2);
        entityManager.persist(customer);
        System.out.println( company1.getLstCupons());
    }
    public void addCompany(){
        entityManager.persist(company1);
        System.out.println(company1);
    }
    public void addCupon(){

    }
    @Override
    public void run(String... args) throws Exception {
//        addCustomer();
//        addCompany();
        addCustomer();
    }
}
