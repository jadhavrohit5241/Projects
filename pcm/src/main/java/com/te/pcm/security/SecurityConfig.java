package com.te.pcm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // its req when we using @PreAuthorized("hasRole('ADMIN')")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userdetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/auth/login", "/auth/logout").permitAll();
		http.authorizeRequests().antMatchers("/auth/qualityAssurance/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/auth/employee/**").permitAll();
		http.authorizeRequests().antMatchers("/auth/warehouse/**").hasAnyRole("USER", "ADMIN").anyRequest()
				.authenticated().and().httpBasic();
	}

	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userdetailsService);
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		return daoAuthenticationProvider;
	}
}

/**
 * Inmemory AUTHERIZATION
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 *           Exception { encoded password
 * 
 *           auth.inMemoryAuthentication().withUser("xxx").password(this.passwordEncoder().encode("12345")).roles("ADMIN");
 *           }
 * 
 * @Bean public BCryptPasswordEncoder passwordEncoder() {
 * 
 *       return new BCryptPasswordEncoder(); // to get object for
 *       PasswordEncoder
 **/
