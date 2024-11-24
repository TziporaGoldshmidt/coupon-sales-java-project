package com.example.finalproject.Controllers;


import com.example.finalproject.Login.LoginManager;
import com.example.finalproject.Model.Credentionals;
import com.example.finalproject.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientController {

    @Autowired
    protected LoginManager loginManager;
    @Autowired
    protected JwtUtils jwtUtils;

}
