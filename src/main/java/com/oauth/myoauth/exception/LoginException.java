package com.oauth.myoauth.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.oauth.myoauth.exception.serializer.LoginExceptionSerializer;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

@JsonSerialize(using = LoginExceptionSerializer.class)
public class LoginException extends OAuth2Exception {
    public LoginException(String msg) {
        super(msg);
    }
}
