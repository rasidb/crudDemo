package com.luv2code.springboot.cruddemo.security;


import javax.sql.DataSource;

//@Configuration
public class DemoSecurityConfig {
    /*
   String baseURI = "/api/employees";
    String employee = "EMPLOYEE";
    String manager = "MANAGER";
    String admin = "ADMIN";

    //add support for jdbc


     *
     * @param dataSource
     * @return username ve authları ayarlamadan return new JdbcUserDetailsManager(dataSource); komudunu kullanmak default olarak şimdiki db tablosunu veriyor
     * ileride tabloyu değiştirdiğinde methodun içinde yazanları kullan

  //  @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager =new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password, enabled from users where username=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username, authority from authorities where username=?");
        return jdbcUserDetailsManager;
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
    */
}
  /*

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
     */
