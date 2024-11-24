package com.example.finalproject.Login;

import com.example.finalproject.Model.ClientType;
import com.example.finalproject.Model.Credentionals;
import com.example.finalproject.Services.AdminService;
import com.example.finalproject.Services.ClientService;
import com.example.finalproject.Services.CompanyService;
import com.example.finalproject.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Scope("singleton")
public class LoginManager {
    @Autowired
    AdminService adminService;
    @Autowired
    CompanyService companyService;
    @Autowired
    CustomerService customerService;

    public LoginManager() {

    }
    public ClientService login(Credentionals credentionals, ClientType clientType) {


        boolean boolLogin=false;
        ClientService clientService=null;
        switch (clientType){
            case Admin:
                clientService=adminService;
                boolLogin=clientService.login(credentionals);
                break;
            case Company:
                clientService=companyService;
                boolLogin=clientService.login(credentionals);
                break;
            case Customer:
                clientService=customerService;
                boolLogin=clientService.login(credentionals);
                break;
        }
        if(!boolLogin)
            return null;
        return clientService;

    }

}
