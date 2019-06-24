package com.oauth.myoauth.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "user")
public class User implements Serializable {
    @Id
    private String id;
    @Indexed
    private String userName;
    private String password;
}
