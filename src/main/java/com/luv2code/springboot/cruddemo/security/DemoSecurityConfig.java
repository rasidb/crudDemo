package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    String baseURI = "/api/employees";
    String employee = "EMPLOYEE";
    String manager = "MANAGER";
    String admin = "ADMIN";

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails employee = User.builder()
                .username("employee")
                .password("{noop}employee")
                .roles(this.employee)
                .build();

        UserDetails admin =User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles(this.admin,this.manager,this.employee)
                .build();
        UserDetails manager =User.builder()
                .username("manager")
                .password("{noop}manager")
                .roles(this.manager,this.employee)
                .build();
        return new InMemoryUserDetailsManager(employee,admin,manager);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, baseURI).hasRole(employee)
                        .requestMatchers(HttpMethod.GET, baseURI + "/**").hasRole(employee)
                        .requestMatchers(HttpMethod.PUT, baseURI).hasRole(manager)
                        .requestMatchers(HttpMethod.POST, baseURI).hasRole(manager)
                        .requestMatchers(HttpMethod.DELETE, baseURI + "/**").hasRole(admin)

        );
        //use http basic authentication
        http.httpBasic(Customizer.withDefaults());
        //disable cross site request forgery (csrf)
        //in general, not required for stateless rest apis that use post,put, delete, and/or patch
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
