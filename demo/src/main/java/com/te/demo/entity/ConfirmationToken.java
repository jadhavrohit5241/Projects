package com.te.demo.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class ConfirmationToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tokenId;
	private String confirmationToken;

	@OneToOne(targetEntity = Employee.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "employeeId")
	private Employee employee;

	public ConfirmationToken(Employee employee) {
		this.employee = employee;
		 confirmationToken = UUID.randomUUID().toString();
	}
	
	
}
