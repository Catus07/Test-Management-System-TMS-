package com.report.tms.controller;


import com.report.tms.config.CustomLoginHandler;
import com.report.tms.model.UserInformation;
import com.report.tms.repo.UserInfoRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @Autowired
    public UserInformation userInformation;

    @Autowired
    public UserInfoRepo userInfoRepo;

    @GetMapping("/test")
    public String username(){
        return "test successful ";
    }


}
