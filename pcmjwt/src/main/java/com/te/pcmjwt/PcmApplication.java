package com.te.pcmjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.collect.Lists;
import com.te.pcmjwt.entity.Roles;
import com.te.pcmjwt.repository.RolesRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class PcmApplication {
	@Autowired
	private RolesRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(PcmApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {

			Roles userRole = Roles.builder().roleName("ROLE_USER").build();

			Roles adminRole = Roles.builder().roleName("ROLE_ADMIN").appUser(Lists.newArrayList()).build();

			if (roleRepository.findByRoleName("ROLE_USER").isEmpty()
					&& roleRepository.findByRoleName("ROLE_ADMIN").isEmpty()) {
				roleRepository.save(userRole);
				roleRepository.save(adminRole);
			}
		};
	}

}
