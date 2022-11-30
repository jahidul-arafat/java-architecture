package com.example.bootingweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity      // will turn off the basic authentication and turn on Form based authentication
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        Strategy:
        Let everyone come at the concert gate but not everyone get the access.
        Individuals with the authentic ticket could only pass the gate and enter into the concert zoom,
        Next time s/he wants to use the GATE can easily do it without further authentication as the session exists like a Yellow Wrist Brand showing his/her authenticity
        i.e.(very first time) http://localhost:8080/rooms -> redirect to http://localhost:8080/login -->
        once authenticated with <username> and <password> -> redirect to source api call <http://localhost:8080/rooms>

        (next api call) http://localhost:8080/rooms -> does not require reauthenticatiion {earlier authentication session persist}
         */
        // Let everyone come to Gate, where Gate is "/", "/api/*", "/api/rest/*" :: antPattern
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll() // let authorize all requests coming for localhost:8080/ localhost:8080/api/room etc
                .anyRequest().authenticated() // But let now everyone pass into. Authenticate everyone with <username> and <password>. I yet to build this authentication; I am gonna build the default in-memory authentication below.
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }

    // Build the in-memory authentication | create in-memory username and password which will be used for authentication later
    // once the login page is ready and the very first request redirected to /login page for authentication with <username> and <password>
    // the next step would be, what will be the <username> and <password>?
    // Default implementation rely on in-memory <username> and <password>
    @Autowired
    public void ConfigureGlobal(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder
                .inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance()) // // means, passwords are not encoded
                                                                    // better to encode the password with BCrypt
                                                                    // inMemoryAuthentication() might throw Unhandled Exception
                .withUser("jahidapon@gmail.com")
                .password("demopass")
                .roles("USER");


    }

}
