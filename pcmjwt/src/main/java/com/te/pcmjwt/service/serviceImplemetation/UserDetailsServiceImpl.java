package com.te.pcmjwt.service.serviceimplemetation;

import java.util.Optional;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.pcmjwt.entity.AppUser;
import com.te.pcmjwt.entity.Roles;
import com.te.pcmjwt.repository.AppUserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AppUserRepository appUserRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> optionalAU = appUserRepository.findByUsername(username);
		if (optionalAU.isPresent()) {
			AppUser appUser = optionalAU.get();
			Function<Roles, SimpleGrantedAuthority> function = r -> {
				return new SimpleGrantedAuthority(r.getRoleName());
			};
			Set<SimpleGrantedAuthority> authorities = appUser.getRoles().stream().map(function)
					.collect(Collectors.toSet());

			return new User(username, appUser.getPassword(), authorities);
		}
		throw new UsernameNotFoundException("User with username '" + username + "' does not exist!");
	}

}
