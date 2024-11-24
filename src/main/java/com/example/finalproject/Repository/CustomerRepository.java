package com.example.finalproject.Repository;

import com.example.finalproject.Model.Category;
import com.example.finalproject.Model.Credentionals;
import com.example.finalproject.Model.Cupon;
import com.example.finalproject.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select cup from Cupon cup where cup.id IN (select cup.id from cup.customer cust where cust.id=?1 and cup.id=?2)")
    public Cupon findCustomerCupon(long customerId, long cuponId);
    public boolean existsByCredentionals(Credentionals credentionals);
    @Query("select cust.lstCupons from Customer cust where cust.id=?1")
    public List<Cupon> getLstCupons(long custId);
    @Query("select cup from Cupon cup where cup.customer.id=?1 and cup.category=?2")
    public List<Cupon> getLstCupons(long custId, Category category);

    @Query("select cup from Cupon cup where cup.customer.id=?1 and cup.price<=?2")
    public List<Cupon> getLstCupons(long custId, double maxPrice);


}
