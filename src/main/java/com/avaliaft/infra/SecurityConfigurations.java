package com.avaliaft.infra;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {



    //"porteiro do sistema" ele Define QUEM pode acessar O QUÊ
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(crsf -> crsf.disable())

                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST,"/auth/register").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }

    //Valida o login
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config )
    throws Exception{

        return config.getAuthenticationManager();

    }


    //Protege a senha
    @Bean
    public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
    }

}
