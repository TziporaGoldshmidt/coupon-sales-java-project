package com.example.finalproject.Services;


import com.example.finalproject.Model.Category;
import com.example.finalproject.Model.Credentionals;
import com.example.finalproject.Model.Cupon;
import com.example.finalproject.Model.Customer;

import com.example.finalproject.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Service
public class CustomerService extends ClientService{
    private long custId=1;

    @Override
    public boolean login(Credentionals credentionals) {

        return customerRepository.existsByCredentionals(credentionals);
    }
    public void purchaseCupon(long cuponId) throws Exception {
        Customer cust=customerRepository.findById(custId).get();
        Cupon cup=cuponRepository.findById(cuponId).get();
        if(!cuponRepository.existsById(cuponId))
            throw new Exception("cupon is not exist!");
        if(cuponRepository.findById(cuponId).get().getAmount()==0)
            throw new Exception("out of stock!");
        if(customerRepository.findCustomerCupon(custId,cuponId)!=null)
            throw new Exception("cant buy more than once");
        if(cup.getEndDate().compareTo(LocalDate.now())<0)
            throw new Exception("the cupon is finished");

        cup.setAmount(cup.getAmount()-1);
        cuponRepository.save(cup);
        cust.addCupon(cup);
        customerRepository.save(cust);
   }
   public List<Cupon> getCustomerCupons(){
        return customerRepository.getLstCupons(custId);
    }
    public List<Cupon> getCustomerCupons(Category category){
        return customerRepository.getLstCupons(custId,category);
    }
    public List<Cupon> getCustomerCupons(double maxPrice){
        return customerRepository.getLstCupons(custId,maxPrice);
    }
    public Customer getCustomerDetails(){
        return customerRepository.findById(custId).get();
    }



//    public boolean isCustomerExist(long id){
//        return customerRepository.existsById(id);
//    }
//    public void addCustomer(Customer customer){
//        customerRepository.save(customer);
//    }
//    public void updateCustomer(long id,Customer customer){
//        customer.setId(id);
//        customerRepository.save(customer);
//    }
//    public void deleteCustomer(long id){
//        customerRepository.deleteById(id);
//    }
//    public Customer getCustomerById(long id){
//        return customerRepository.findById(id).get();
//    }
}
