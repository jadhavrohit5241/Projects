package com.te.postgresdemo.model;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

/*
*   req for created by and audited by
*
*/

public class AuditorAwareImplementation implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("ABC");
	}

}
