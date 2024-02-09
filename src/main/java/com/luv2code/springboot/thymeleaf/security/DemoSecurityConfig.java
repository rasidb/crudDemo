package com.luv2code.springboot.thymeleaf.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        String employeeRole = "employee";
        String managerRole = "manager";
        String adminRole = "admin";
        UserDetails manager = User.builder()
                .username(managerRole)
                .password("{noop}" + managerRole)
                .roles(managerRole, employeeRole).build();

        UserDetails admin = User.builder()
                .username(adminRole)
                .password("{noop}" + adminRole)
                .roles(adminRole, managerRole, employeeRole).build();

        UserDetails employee = User.builder()
                .username(employeeRole)
                .password("{noop}" + employeeRole)
                .roles(employeeRole).build();
        return new InMemoryUserDetailsManager(manager, admin, employee);
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .anyRequest().authenticated()   //tüm isteklerin kimlik doğrulaması gerektireceğini belirtir
                )
                .formLogin(form ->
                        form
                                .loginPage("/employees/showLoginPage") //bu sayfayı açarak gerekli kimlik doğrulamasını başlatır
                                .loginProcessingUrl("/authenticateTheUser") //kimlik doğrulamasının gerçekleşeceği url
                                .permitAll())
                .logout(LogoutConfigurer::permitAll);   //bu url'e gitmek için bi kimlik doğrulamasını geçmeye gerek yok
        return http.build();
    }
}
