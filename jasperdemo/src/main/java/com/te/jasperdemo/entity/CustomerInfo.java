package com.te.jasperdemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.swing.event.ListSelectionEvent;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerInfo {

	@Id
	private String customerid;
	private String customerName;
	private String customerEmailId;
	private String adress;
	private String cutomerPassword;

	@JsonIgnore
	@ManyToMany(mappedBy = "customerInfos",cascade = CascadeType.ALL)
	private List<OrderInfo>orderInfos;



}
