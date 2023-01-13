package com.te.securityjwt;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.google.common.collect.Lists;
import com.te.securityjwt.entity.AppUser;
import com.te.securityjwt.entity.Roles;
import com.te.securityjwt.repository.AppUserRepository;
import com.te.securityjwt.repository.RolesRepository;

@SpringBootApplication
public class SecurityjwtApplication {

	@Autowired
	private RolesRepository roleRepository;
	@Autowired
	private AppUserRepository appUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecurityjwtApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			Roles defaultRoles = Roles.builder().roleName("ROLE_ADMIN").appUser(Lists.newArrayList()).build();
			if (roleRepository.findByRoleName("ROLE_USER").isEmpty()
					&& roleRepository.findByRoleName("ROLE_ADMIN").isEmpty()) {
				if (appUserRepository.findByUsername("defaultUser").isEmpty()) {
					appUserRepository.save(AppUser.builder().username("defaultUser").password(new BCryptPasswordEncoder().encode("12345"))
							.roles(Arrays.asList(defaultRoles)).build());
				}
				roleRepository.save(Roles.builder().roleName("ROLE_USER").build());
				roleRepository.save(defaultRoles);
			}
		};
	}

}
