package com.oauth.myoauth.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceHandler {

    @ExceptionHandler(Exception.class)
    public String defultExcepitonHandler(Exception e) {

        return "123";
    }

}
