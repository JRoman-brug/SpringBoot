package com.example.tacoroman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.tacoroman.domain.User;
import com.example.tacoroman.repository.UserRepository;

import lombok.extern.java.Log;

@Log
@Configuration
@EnableMethodSecurity
public class securityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(auth -> auth
                    // .requestMatchers(HttpMethod.POST, "/admin/**")This one way for restric access to methods
                    // .hasRole("ADMIN")
                    .requestMatchers("/design", "/orders")
                    .hasRole("USER")
                    // .access((authentication, access)-> { //This is for a complex access, for
                    // examples if user has role USER and is tuesday XD
                    // boolean isUser =
                    // authentication.get().getAuthorities().stream().anyMatch(grantedAuthority ->
                    // grantedAuthority.getAuthority().equals("USER"));
                    // boolean isTuesday = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) ==
                    // Calendar.TUESDAY;
                    // return new AuthorizationDecision(isUser && isTuesday);
                    // })
                    .requestMatchers("/", "/**","/login", "/h2-console/**").permitAll())
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/design", true))
            .httpBasic(httpBasic->{}) // This shit is for postman can authicated
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**")
                .disable()
            )
            .headers(header -> header
                    .frameOptions(frame -> frame.sameOrigin()))
            .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);
            log.info("FUUUUUUCK");
            if (user != null){
                return user;
            }
            throw new UsernameNotFoundException("User " + username + " not found");
        };
    }

}
