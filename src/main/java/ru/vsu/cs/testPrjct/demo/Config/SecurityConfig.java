package ru.vsu.cs.testPrjct.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(
                        (x) -> x.requestMatchers("/registration", "/", "/api/user", "/api-docs")
                                .permitAll()
                                .requestMatchers("/student").authenticated()
                                .anyRequest().hasRole("ADMIN"))
                .formLogin(
                        (x) -> x
                                .defaultSuccessUrl("/", true)
                                .permitAll())
                .logout(
                        (x) -> x
                                .logoutSuccessUrl("/")
                                .logoutUrl("/logout"))
                .build();
    }
}
