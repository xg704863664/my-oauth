package com.oauth.myoauth.service;

import com.alibaba.fastjson.JSON;
import com.oauth.myoauth.dao.UserDao;
import com.oauth.myoauth.entity.User;
import com.oauth.myoauth.entity.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Service("UserDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisTokenStore redisTokenStore;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = findUser(userName);
        return new UserDetailsImpl(user);
    }

    public User findUser(String userName){
        String json = redisTemplate.opsForValue().get("user:"+userName);
        if (StringUtils.isEmpty(json)) {
            User  user = userDao.findByUserName(userName);
            redisTemplate.opsForValue().set("user:"+user.getUserName(), JSON.toJSONString(user));
            return user;
        }else {
            User user =  JSON.parseObject(json,User.class);
            return user;
        }
    }
}
