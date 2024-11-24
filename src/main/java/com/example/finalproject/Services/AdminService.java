package com.example.finalproject.Services;

import com.example.finalproject.Model.Company;
import com.example.finalproject.Model.Credentionals;
import com.example.finalproject.Model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService extends ClientService{

    public Company addCompany(Company company){
        return companyRepository.save(company);
    }
    public Company updateCompany(long id,Company company){
        company.setId(id);
        return companyRepository.save(company);
    }
    public void deleteCompany(long id){
        companyRepository.deleteById(id);
    }
    public Company getCompanyById(long id){
        return companyRepository.findById(id).get();
    }
    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }
    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public Customer updateCustomer(long id,Customer customer){
        customer.setId(id);
        return customerRepository.save(customer);
    }
    public void deleteCustomer(long id){
        customerRepository.deleteById(id);
    }
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Customer getCustomerById(long id){
        return customerRepository.findById(id).get();
    }


    @Override
    public boolean login(Credentionals credentionals) {
        return credentionals.getEmail().equals("admin@admin.com")&&credentionals.getPassword().equals("admin");
    }
}
