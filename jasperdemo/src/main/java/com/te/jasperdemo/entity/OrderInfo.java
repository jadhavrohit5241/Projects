package com.te.jasperdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
public class OrderInfo {

	@Id
	private String orderId;

	private String timestamp;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "map_cutomer_order", inverseJoinColumns = @JoinColumn(name = "cutomer_fk"), joinColumns = @JoinColumn(name = "order_fk"))
	private List<CustomerInfo> customerInfos = new ArrayList<>();

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "map_product_order", inverseJoinColumns = @JoinColumn(name = "product_fk"), joinColumns = @JoinColumn(name = "order_fk"))
	private List<Product> products = new ArrayList<>();
}
