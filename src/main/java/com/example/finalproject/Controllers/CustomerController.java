package com.example.finalproject.Controllers;

import com.example.finalproject.Model.*;
import com.example.finalproject.Services.CompanyService;
import com.example.finalproject.Services.CustomerService;
import com.example.finalproject.jwt.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController extends ClientController{
    @Autowired
    private CustomerService customerService;
//    @Override
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Credentionals credentionals) {
    customerService=(CustomerService) loginManager.login(credentionals, ClientType.Customer);
    if(customerService!=null){
        String token = jwtUtils.generateToken(credentionals, ClientType.Customer);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
    else{
        return new ResponseEntity<String>("Invalid Email or Password...", HttpStatus.UNAUTHORIZED);
    }

}
    @PostMapping("/purchaseCupon")
    public void purchaseCupon(@RequestBody long cuponId) throws Exception {
        customerService.purchaseCupon(cuponId);
    }
    @GetMapping("/getCustomerCupons")
    public List<Cupon> getCustomerCupons(){return customerService.getCustomerCupons();}
    @GetMapping("/getCustomerCuponsByCategory")
    public List<Cupon> getCustomerCuponsByCategory(@RequestParam("category") Category category){return customerService.getCustomerCupons(category);}
    @GetMapping("/getCustomerCuponsByMaxPrice")
    public List<Cupon> getCustomerCuponsByMaxPrice(@RequestParam("maxPrice") double maxPrice){return customerService.getCustomerCupons(maxPrice);}
    @GetMapping("/getCustomerDetails")
    public Customer getCustomerDetails(){return customerService.getCustomerDetails();}




}
