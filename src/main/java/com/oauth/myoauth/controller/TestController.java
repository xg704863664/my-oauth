package com.oauth.myoauth.controller;

import com.oauth.myoauth.entity.User;
import com.oauth.myoauth.entity.UserDetailsImpl;
import com.oauth.myoauth.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserDetailServiceImpl userDetailService;
    @RequestMapping("/test/t")
    public List<String> test(){
        List<String>  c =  new ArrayList<>();
                c.add("1231");
        return c;
    }

    @RequestMapping("/test/user")
    public User testUser(Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return  userDetailService.findUser(userDetails.getUsername());
    }
}
