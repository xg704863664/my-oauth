package com.oauth.myoauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig implements ResourceServerConfigurer {
    @Value("${spring.application.name}")
    private String appName;
    @Override
    public void configure(ResourceServerSecurityConfigurer resourceServerSecurityConfigurer) throws Exception {
//        resourceServerSecurityConfigurer.resourceId(AuthorizationServerConfig.resourceIds);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
                 httpSecurity
                         .authorizeRequests()
                         .mvcMatchers("/api/**").authenticated()
                         .antMatchers("/"+appName+"/**").permitAll();
    }
}
