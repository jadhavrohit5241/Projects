package com.te.jasperdemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
public class Product {

	@Id
	private String productId;
	
	private String productName;

	private String productDesc;

	private Double productPrice;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "products",cascade = CascadeType.ALL)
	private List<OrderInfo>orderInfos;

}
