package com.te.postgresdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import com.te.postgresdemo.model.AuditorAwareImplementation;

@Configuration
public class AuditorConfig {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImplementation();
	}

}
