package com.te.demo.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class AppResponse{
	private boolean error;
	private String message;
	private LocalDateTime timestamp;
	private String token;
	private List<Object> data;

}
