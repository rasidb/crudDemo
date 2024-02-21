package com.luv2code.springboot.thymeleaf.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
public class DemoSecurityConfig {
    String employeeRole = "employee";
    String managerRole = "manager";
    String adminRole = "admin";

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password, enabled from users where username=? ");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username, authority from authorities where username=?");
        return jdbcUserDetailsManager;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer.requestMatchers("/employees/").hasRole(employeeRole).requestMatchers("/employees/managers/**").hasRole(managerRole).requestMatchers("/employees/admins/**").hasRole(adminRole).anyRequest().authenticated()   //tüm isteklerin kimlik doğrulaması gerektireceğini belirtir
                ).exceptionHandling(configurer -> configurer.accessDeniedPage("/employees/access-denied"))//yetkisiz istekte bu adrese yönlendir

                .formLogin(form -> form.loginPage("/employees/showLoginPage") //bu sayfayı açarak gerekli kimlik doğrulamasını başlatır
                        .loginProcessingUrl("/authenticateTheUser") //kimlik doğrulamasının gerçekleşeceği url
                        .permitAll()).logout
                        (LogoutConfigurer::permitAll);//bu url'e gitmek için bi kimlik doğrulamasını geçmeye gerek yok

        return http.build();
    }


  /*  @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

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
    }*/

}
