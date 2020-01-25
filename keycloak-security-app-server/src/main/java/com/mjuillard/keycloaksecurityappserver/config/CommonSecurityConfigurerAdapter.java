package com.mjuillard.keycloaksecurityappserver.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

public class CommonSecurityConfigurerAdapter extends AbstractHttpConfigurer<CommonSecurityConfigurerAdapter, HttpSecurity> {

	@Override
	public void init(HttpSecurity http) throws Exception {

		http
        // disable csrf because of API mode
        .csrf().disable()
        
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        // manage routes securisation here
        .and()
            .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()

                .antMatchers("/logout", "/", "/unsecured").permitAll()
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")

                .anyRequest().denyAll();

	}
	
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList(HttpMethod.OPTIONS.name(), "GET","POST"));
        configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers", "Access-Control-Allow-Origin", "Authorization"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
