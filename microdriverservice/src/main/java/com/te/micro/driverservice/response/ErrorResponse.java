package com.te.micro.driverservice.response;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class ErrorResponse {
	private Boolean error;
	private int status;
	private String timestamp;
	private String errorMessage;
}
