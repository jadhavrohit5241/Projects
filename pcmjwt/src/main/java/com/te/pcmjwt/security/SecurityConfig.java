//package com.te.pcmjwt.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.te.pcmjwt.jwtfilter.SecurityFilter;
//
//import lombok.RequiredArgsConstructor;
//
////@RequiredArgsConstructor
////@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig  {
////	private final PasswordEncoder passwordEncoder;
////	private final UserDetailsService userDetailsService;
////	private final SecurityFilter securityFilter;
////
////	@Bean
////	@Override
////	protected AuthenticationManager authenticationManager() throws Exception {
////		return super.authenticationManager();
////	}
////
////	@Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
////	}
////
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
//////		http.csrf().disable();
//////		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//////		http.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
////	}
//}
///**
// * INMEMORY AUTHERIZATION
// * 
// * @Override protected void configure(AuthenticationManagerBuilder auth) throws
// *           Exception { encoded password
// * 
// *           auth.inMemoryAuthentication().withUser("xxx").password(this.passwordEncoder().encode("12345")).roles("ADMIN");
// *           }
// * 
// * @Bean public BCryptPasswordEncoder passwordEncoder() {
// * 
// *       return new BCryptPasswordEncoder(); // to get object for
// *       PasswordEncoder
// **/
