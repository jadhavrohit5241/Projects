package com.te.pcmjwt.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariations {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer productVariationId;

	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "productVariationId")
//	private List<ProductVariationOptions> produVariationOptions;
}
