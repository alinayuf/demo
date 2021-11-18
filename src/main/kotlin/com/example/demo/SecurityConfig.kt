package com.example.demo

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    
    override fun configure(http: HttpSecurity) {
        with(http) {
            authorizeRequests()
                .antMatchers("/events/**").permitAll()
                .antMatchers("/actuator/**").permitAll()
        }
        http.csrf().disable()
    }
}