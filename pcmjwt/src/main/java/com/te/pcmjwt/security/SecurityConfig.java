package com.te.pcmjwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.te.pcmjwt.jwtfilter.SecurityFilter;

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private SecurityFilter securityFilter;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable();
		http.authorizeRequests().antMatchers("/auth/employee/**").permitAll();
		http.authorizeRequests().antMatchers("/auth/qualityAssurance/**").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/auth/warehouse/**").hasRole("USER").anyRequest().authenticated();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

}

/**
 * @Autowired private UserDetailsService userdetailsService;
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 *           http.csrf().disable();
 *           http.authorizeRequests().antMatchers("/auth/login",
 *           "/auth/logout").permitAll();
 *           http.authorizeRequests().antMatchers("/auth/qualityAssurance/**").hasRole("ADMIN");
 *           http.authorizeRequests().antMatchers("/auth/employee/**").permitAll();
 *           http.authorizeRequests().antMatchers("/auth/warehouse/**").hasAnyRole("USER",
 *           "ADMIN").anyRequest() .authenticated().and().httpBasic(); }
 * 
 * @Bean AuthenticationProvider authenticationProvider() {
 *       DaoAuthenticationProvider daoAuthenticationProvider = new
 *       DaoAuthenticationProvider();
 *       daoAuthenticationProvider.setUserDetailsService(userdetailsService);
 *       daoAuthenticationProvider.setPasswordEncoder(new
 *       BCryptPasswordEncoder()); return daoAuthenticationProvider; }
 **/

/**
 * INMEMORY AUTHERIZATION
 * 
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
