package com.example.finalproject.Controllers;

import com.example.finalproject.Model.*;
import com.example.finalproject.Services.AdminService;
import com.example.finalproject.Services.CompanyService;
import com.example.finalproject.jwt.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController extends ClientController{
    @Autowired
    private CompanyService companyService;

    @GetMapping("getCompanyDetails")
    public Company getCompanyDetails(){return companyService.getCompanyDetails();}

    @GetMapping("/getCompanyCupons")
    public List<Cupon> getCustomerCupons(){return companyService.getCompanyCupons();}
    @GetMapping("/getCompanyCuponsByCategory")
    public List<Cupon> getCustomerCuponsByCategory(@RequestParam("category") Category category){return companyService.getCompanyCupons(category);}
    @GetMapping("/getCompanyCuponsByMaxPrice")
    public List<Cupon> getCustomerCuponsByMaxPrice(@RequestParam("maxPrice") double maxPrice){return companyService.getCompanyCupons(maxPrice);}
    @PostMapping("/addCupon")
    public boolean addCupon(@RequestBody Cupon cupon){
        try {
            companyService.addCupon(cupon);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @PutMapping("/updateCupon/{id}")
    public Cupon updateCupon(@RequestBody Cupon cupon,@PathVariable Long id){
        try {
            return companyService.updateCupon(id,cupon);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @DeleteMapping("/deleteCupon/{id}")
    public boolean deleteCupon(@PathVariable Long id){
        return companyService.deleteCupon(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Credentionals credentionals) {
        companyService=(CompanyService) loginManager.login(credentionals, ClientType.Company);
        if(companyService!=null){
            String token = jwtUtils.generateToken(credentionals, ClientType.Company);
            return ResponseEntity.ok(new AuthenticationResponse(token));
        }
        else{
            return new ResponseEntity<String>("Invalid Email or Password...", HttpStatus.UNAUTHORIZED);
        }

    }

}
