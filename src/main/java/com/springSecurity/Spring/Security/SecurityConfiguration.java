package com.springSecurity.Spring.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.AbstractConfiguredSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.authorizeHttpRequests(registry -> {
                registry.requestMatchers("/home").permitAll();
                registry.requestMatchers("/admin/**").hasRole("ADMIN");
                registry.requestMatchers("/user/**").hasRole("USER");
                registry.anyRequest().authenticated();
        })
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();

    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails normalUser = User.builder()
                .username("abc")
                .password("$2a$12$6WmLgYEid4V/qk8pSjd7PeNTCQKk8tAU4yHoNrfiEvb7x1AaQn.hm")
                .roles("USER")
                .build();
        UserDetails adminUser = User.builder()
                .username("thiraj")
                .password("$2a$12$Rj7pQkv.P3RSip36ti6NR.yV82jEDoOlAx7ETtMiwEqrs.b3OHFX.")
                .roles("ADMIN","USER")
                .build();
        return new InMemoryUserDetailsManager(adminUser,normalUser);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
