package com.oauth.myoauth.controller;

import com.oauth.myoauth.entity.User;
import com.oauth.myoauth.entity.UserDetailsImpl;
import com.oauth.myoauth.service.UserDetailServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(description = "TestController  测试")
public class TestController {

    @Autowired
    private UserDetailServiceImpl userDetailService;
    @ApiOperation(value = "测试test",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping("/test/t")
    public List<String> test(){
        List<String>  c =  new ArrayList<>();
                c.add("1231");
        return c;
    }

    @ApiOperation(value = "测试test-user",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping("/test/user")
    public User testUser(@ApiIgnore Principal principal){
        Authentication authentication = (Authentication) principal;
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return  userDetailService.findUser(userDetails.getUsername());
    }

    @ApiOperation(value = "测试test-user",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping("/test1/code")
    public String getCode(@RequestParam(value = "code") String code){

        return  code;
    }
}
