package com.oauth.myoauth;

import com.oauth.myoauth.dao.UserDao;
import com.oauth.myoauth.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyOauthApplicationTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RedisTokenStore redisTokenStore;
    @Test
    public void contextLoads() {
//        Optional<User> o = userDao.findById("5d0ae25acfa67e254c5faafe");
//        User user = o.get();
//        System.out.println(user.getUserName());
//        user.setPassword(bCryptPasswordEncoder.encode("1234777"));
//        userDao.save(user);
        Collection<OAuth2AccessToken> tokensByClientIdAndUserName = redisTokenStore.findTokensByClientIdAndUserName("myclient", "admin");
        Iterator<OAuth2AccessToken> oAuth2AccessTokenIterator = tokensByClientIdAndUserName.iterator();
        while ( oAuth2AccessTokenIterator.hasNext()) {
            OAuth2AccessToken oAuth2AccessToken = oAuth2AccessTokenIterator.next();
            System.out.println(oAuth2AccessToken.getValue());

        }
    }

}
