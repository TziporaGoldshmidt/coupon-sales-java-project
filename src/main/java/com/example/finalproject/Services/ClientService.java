package com.example.finalproject.Services;

import com.example.finalproject.Model.Credentionals;
import com.example.finalproject.Repository.CompanyRepository;
import com.example.finalproject.Repository.CuponRepository;
import com.example.finalproject.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class ClientService {
    @Autowired
    protected CuponRepository cuponRepository;
    @Autowired
    protected CustomerRepository customerRepository;
    @Autowired
    protected CompanyRepository companyRepository;
    public abstract boolean login(Credentionals credentionals);

}
