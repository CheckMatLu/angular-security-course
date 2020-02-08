package com.mjuillard.keycloaksecurityappserver.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

public class CommonSecurityConfigurerAdapter extends AbstractHttpConfigurer<CommonSecurityConfigurerAdapter, HttpSecurity> {

	private final static String ROLE_ADMIN = "ADMIN";
	private final static String ROLE_USER = "USER";
	
	@Override
	public void init(HttpSecurity http) throws Exception {

		http
        .cors().and()
        // disable csrf because of API mode
        .csrf().disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        // manage routes securisation here
        .and()
            .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()

                .antMatchers("/logout", "/").permitAll()
//                .antMatchers("/user").hasRole("USER")
//                .antMatchers("/admin").hasRole(ROLE_ADMIN)
                
                .antMatchers("/customers/**").hasRole(ROLE_USER)
                .antMatchers("/users/**").hasRole(ROLE_ADMIN)
                
                .antMatchers("/h2-console/**").permitAll()
                
                .anyRequest().denyAll()
		
                .and().headers().frameOptions().disable();

	}
	
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//        configuration.setAllowCredentials(true);
//        configuration.setAllowedMethods(Arrays.asList(HttpMethod.OPTIONS.name(), "GET","POST"));
//        configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers", "Access-Control-Allow-Origin", "Authorization"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
}
