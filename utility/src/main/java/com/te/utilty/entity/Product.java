package com.te.utilty.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {

//	@Column(name="id",nullable=false,unique=true)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	@Id
	private String productName;

	private String productDesc;

	private Double productPrice;

}
