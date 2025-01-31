package com.example.TeamProject;

import com.example.TeamProject.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {

    private final UserService userService;

    // Inject UserService that implements UserDetailsService
    public Config(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/home").permitAll()  // Anyone can access home
                        .requestMatchers("/users/**").hasRole("USER") // Users can access user routes
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Admin can access admin routes
                        .requestMatchers("/items/**").hasAnyRole("USER", "ADMIN") // Both user and admin can read items
                        .anyRequest().permitAll())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        // Directly use the userService as the UserDetailsService
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userService)  // Set your UserService here
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }
}
