package com.te.pcmjwt.jwtutil;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.bytebuddy.asm.Advice.Local;

@Component
public class JwtUtil {
	private String secret = "any secret key";

	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}

	public boolean isTokenExpired(String token) {
		Date expirationDate = getExpirationDate(token);
		return expirationDate.before(new Date(System.currentTimeMillis()));
	}

	public Date getExpirationDate(String token) {
		return getClaims(token).getExpiration();
	}

	public String generateToken(String subject) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(subject);
		builder.setIssuedAt(new Date(System.currentTimeMillis()));
		builder.setIssuer("name_rohit");
		builder.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15)));
		builder.signWith(SignatureAlgorithm.HS256, secret.getBytes());
		return builder.compact();
	}

	public Claims getClaims(String token) {
		JwtParser parser = Jwts.parser();
		parser.setSigningKey(secret.getBytes());
		Jws<Claims> parseClaimsJws = parser.parseClaimsJws(token);
		return parseClaimsJws.getBody();
	}

	public boolean validateToken(String token, String username) {
		String usernameFromToken = getUsername(token);
		return username.equals(usernameFromToken) && !isTokenExpired(token);
	}

	public boolean makeTokenAsExpired(String token) {
		LocalDate exp = LocalDate.of(2000, 10, 1);
		getClaims(token).setExpiration(java.sql.Date.valueOf(exp));
		return true;
	}

}
