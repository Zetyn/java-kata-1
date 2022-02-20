package org.echocat.kata.java.part1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JWTConfig jwtConfig;

    public SecurityConfig(JWTConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Enable CORS and disable CSRF
        http
                .cors().and()
                .csrf().disable();
        //Set session management to stateless
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();
        //Set permissions on endpoints
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/", "/library").permitAll()
                .antMatchers("/library/login/**").permitAll()
                .antMatchers(HttpMethod.GET, "/library/authors").permitAll()
                .antMatchers(HttpMethod.GET, "/library/books/**").permitAll()
                .antMatchers(HttpMethod.GET, "/library/magazines").permitAll()

                .antMatchers(HttpMethod.POST, "/library/books/**").permitAll()
                .antMatchers(HttpMethod.POST, "/library/magazines/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/library/books/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/library/magazines/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/library/books/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/library/magazines/**").permitAll()

                .anyRequest().authenticated()
                .and()
                .apply(jwtConfig);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
