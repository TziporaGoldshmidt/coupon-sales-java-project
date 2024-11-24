package com.example.finalproject.Controllers;

import com.example.finalproject.Model.*;
import com.example.finalproject.Services.AdminService;
import com.example.finalproject.Services.ClientService;
import com.example.finalproject.jwt.AuthenticationResponse;
import com.example.finalproject.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController extends ClientController{


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Credentionals credentionals) {
        adminService= (AdminService) loginManager.login(credentionals, ClientType.Admin);
        if(adminService!=null){
            String token = jwtUtils.generateToken(credentionals, ClientType.Admin);
            return ResponseEntity.ok(new AuthenticationResponse(token));
        }
        else{
            return new ResponseEntity<String>("Invalid Email or Password...", HttpStatus.UNAUTHORIZED);
        }
    }
    @Autowired
    private AdminService adminService;
    @GetMapping("/comany")
    public List<Company> getAllCompanies(){
        return adminService.getAllCompanies();
    }
    @GetMapping("/comany/{id}")
    public Company getCompanyById(@PathVariable Long id){
        return adminService.getCompanyById(id);
    }
    @PostMapping("/comany")
    public Company addCompany(@RequestBody Company company){
        return adminService.addCompany(company);
    }
    @PutMapping("/comany/{id}")
    public Company updateCompany(@RequestBody Company company,@PathVariable Long id){
        return adminService.updateCompany(id,company);
    }
    @DeleteMapping("/comany/{id}")
    public void deleteCompany(@PathVariable Long id){
        adminService.deleteCompany(id);
    }


    @GetMapping("/customer")
    public List<Customer> getAllCustomers(){
        return adminService.getAllCustomers();
    }
    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return adminService.getCustomerById(id);
    }
    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer){
        return adminService.addCustomer(customer);
    }
    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@RequestBody Customer customer,@PathVariable Long id){
        return adminService.updateCustomer(id,customer);
    }
    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Long id){
        adminService.deleteCustomer(id);
    }






}
