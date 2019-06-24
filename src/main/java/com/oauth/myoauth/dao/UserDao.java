package com.oauth.myoauth.dao;

import com.oauth.myoauth.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserDao extends MongoRepository<User,String> {
    User findByUserName(String userName);
    Optional<User> findById(String id);
}
