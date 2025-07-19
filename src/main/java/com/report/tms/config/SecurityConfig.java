package com.report.tms.config;

import com.report.tms.service.TmsUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    public TmsUserDetailsService tmsUserDetailsService;

    @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
       http.cors(Customizer.withDefaults()); //Use whatever global CORS config you've already defined
       http.csrf(csrf-> csrf.disable()); // for development
       http.authorizeHttpRequests(auth->auth
               .requestMatchers("/api/v1/test/","api/v1/home/").permitAll()
               .requestMatchers("/api/v1/admin/**").hasRole("ADMIN")
               .requestMatchers("/api/v1/tester/**").hasRole("TESTER")
               .requestMatchers("/api/v1/dev/**").hasRole("DEVELOPER")
               .anyRequest().authenticated());

       http.formLogin(form->form
               .loginProcessingUrl("/login") // match Vue from post
               .successHandler( new CustomLoginHandler())
               .failureHandler(new CustomAuthFailureHandler())
               .permitAll()

       );
       http.httpBasic(Customizer.withDefaults());

       http.logout(logout-> logout
               //.logoutUrl("")
               .logoutSuccessUrl("/api/v1/LogoutSuccess")

       );

       return  http.build();
   }

   @Bean
   public DaoAuthenticationProvider daoAuthenticationProvider(){
       DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
       dao.setUserDetailsService(tmsUserDetailsService);
       dao.setPasswordEncoder(passwordEncoder());
       return dao;
   }
   @Bean
   public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
   }

}
