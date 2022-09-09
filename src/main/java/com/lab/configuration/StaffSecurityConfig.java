package com.lab.configuration;
 
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.lab.service.StaffUserDetailsService;

import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.SecurityFilterChain;
 
@Configuration
@Order(2)
public class StaffSecurityConfig {
 
    @Bean
    public UserDetailsService staffUserDetailsService() {
        return new StaffUserDetailsService();
    }
 
    @Bean
    public PasswordEncoder passwordEncoder2() {
        return NoOpPasswordEncoder.getInstance();
    }
 
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider2() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(staffUserDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder2());
// 
//        return authProvider;
//    }
 
    @Bean
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
    //    http.authenticationProvider(authenticationProvider2());
 
        http.antMatcher("/customer/**")
            .authorizeRequests().anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/")
                .usernameParameter("email")
                .loginProcessingUrl("/customer/login")
                .defaultSuccessUrl("/customer/home")
                .permitAll()
            .and()
                .logout()
                    .logoutUrl("/staff/logout")
                    .logoutSuccessUrl("/");
 
        return http.build();
    }
}