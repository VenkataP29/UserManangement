package com.lab.configuration;
 
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
 
@Configuration
@Order(2)
public class StaffSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
         
        http.antMatcher("/user/**")
            .authorizeRequests().anyRequest().hasAuthority("USER")
            .and()
            .formLogin()
                .loginPage("/user/login")
                .usernameParameter("email")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/user/staffPage")
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/");
         
        return http.build();
    }  
}


