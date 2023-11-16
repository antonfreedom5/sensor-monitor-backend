package com.yadchenko.sensors.monitor.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.List;
import static com.yadchenko.sensors.monitor.entities.Role.ADMINISTRATOR;
import static com.yadchenko.sensors.monitor.entities.Role.VIEWER;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors().and()
            .csrf().disable()
            .authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/v1/user/login").permitAll()
                .requestMatchers("/v1/sensor/search").hasAnyAuthority(ADMINISTRATOR.getAuthority(), VIEWER.getAuthority())
                .requestMatchers("/v1/sensor/**").hasAuthority(ADMINISTRATOR.getAuthority())
                .requestMatchers("/v1/sensor-type").hasAuthority(ADMINISTRATOR.getAuthority())
                .requestMatchers("/v1/unit-type").hasAuthority(ADMINISTRATOR.getAuthority())
                .anyRequest().authenticated()
            )
            .logout(logout -> logout.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)))
            .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedHeaders(List.of("authorization", "content-type"));
        config.setAllowedMethods(List.of("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedOrigins(List.of("http://localhost:4200"));
        source.registerCorsConfiguration("/**", config);
        return source;
    }

}
