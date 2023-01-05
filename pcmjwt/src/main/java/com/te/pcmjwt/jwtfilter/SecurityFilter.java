//package com.te.pcmjwt.jwtfilter;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.te.pcmjwt.jwtutil.JwtUtil;
//
//import lombok.RequiredArgsConstructor;
//
//@RequiredArgsConstructor
//@Component
//public class SecurityFilter {//extends OncePerRequestFilter {
////	@Autowired
////	private JwtUtil jwtUtil;
////	@Autowired
////	private UserDetailsService userDetailsService;
////
////	@Override
////	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
////			throws ServletException, IOException {
////		String authorization = request.getHeader("Authorization");
////		if ((authorization != null) && authorization.startsWith("Bearer ")) {
////			String token = authorization.substring(7);
////			String usernameFromToken = jwtUtil.getUsername(token);
////			UserDetails userFromDb = userDetailsService.loadUserByUsername(usernameFromToken);
////			if (usernameFromToken != null && userFromDb.getUsername() != null
////					&& SecurityContextHolder.getContext().getAuthentication() == null
////					&& jwtUtil.validateToken(token, userFromDb.getUsername())) {
////
////				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
////						userFromDb.getUsername(), userFromDb.getPassword(), userFromDb.getAuthorities());
////
////				usernamePasswordAuthenticationToken
////						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
////
////				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
////
////			}
////		}
////		filterChain.doFilter(request, response);
////	}
//
//}
