package com.example.Labe.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


   /* @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password("{noop}userPass")
                .roles("USER")
                .build());
        manager.createUser(User.withUsername("admin")
                .password("{noop}adminPass")
                .roles("USER", "ADMIN")
                .build());
        return manager;
    }*/

    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception {
        httpSecurity.csrf()
                .disable()
                .authorizeRequests()
                .requestMatchers(HttpMethod.DELETE)
                .hasRole("ADMIN")
                .requestMatchers("/vi/api/cliente/**","/v1/api/empleado/**")
                .hasAnyRole("USER","ADMIN")
                .requestMatchers("/v1/api/login/**")
                .anonymous()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return httpSecurity.build();
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception {
        httpSecurity.csrf()
                .disable()
                .authorizeRequests()
                .requestMatchers(HttpMethod.DELETE)
                .hasRole("admin")
                .requestMatchers("/vi/api/cliente/**","/v1/api/empleado/**")
                .hasAnyRole("USER","admin")
                .requestMatchers("/v1/api/login/**")
                .anonymous()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(new CustomJwtAuthenticationConverter() );
        httpSecurity.oauth2Login();
        return httpSecurity.build();
    }

}
