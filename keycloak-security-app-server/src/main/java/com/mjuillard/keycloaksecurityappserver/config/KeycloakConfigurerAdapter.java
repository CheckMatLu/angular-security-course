package com.mjuillard.keycloaksecurityappserver.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.preauth.x509.X509AuthenticationFilter;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
@EnableWebSecurity
@ConditionalOnProperty(name = "keycloak.enabled", havingValue = "true", matchIfMissing = true)
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
public class KeycloakConfigurerAdapter extends KeycloakWebSecurityConfigurerAdapter {
		

	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		return new NullAuthenticatedSessionStrategy();
	}

	/*
	 * Override the spring naming for roles: do not need to prefix them with "ROLE_"
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		KeycloakAuthenticationProvider keycloakAuthenticationProvider = super.keycloakAuthenticationProvider();
		// simple Authority Mapper to avoid ROLE_
		keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
		auth.authenticationProvider(keycloakAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		 http
         .sessionManagement()
             .sessionAuthenticationStrategy(sessionAuthenticationStrategy())

         // keycloak filters for securisation
         .and()
             .addFilterBefore(keycloakPreAuthActionsFilter(), LogoutFilter.class)
             .addFilterBefore(keycloakAuthenticationProcessingFilter(), X509AuthenticationFilter.class)
             .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint())

         // delegate logout endpoint to spring security
         .and()
             .logout()
             .addLogoutHandler(keycloakLogoutHandler())
             .logoutUrl("/logout").logoutSuccessHandler(
             // logout handler for API
             (HttpServletRequest request, HttpServletResponse response, Authentication authentication) ->
                     response.setStatus(HttpServletResponse.SC_OK)
          )
             
         .and().apply(new CommonSecurityConfigurerAdapter());

	}

}



