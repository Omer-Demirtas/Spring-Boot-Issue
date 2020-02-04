package com.Person.PersonManager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig extends AbstractSecurityConfig {

    private UserDetailsService userDetailsService ;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/home").access("hasRole('USER')");
        http.authorizeRequests().anyRequest().authenticated();
        http.csrf().disable();
        http.rememberMe().userDetailsService(userDetailsService);
        http.formLogin()
        .loginPage("/login")
        .permitAll();
    }
}
