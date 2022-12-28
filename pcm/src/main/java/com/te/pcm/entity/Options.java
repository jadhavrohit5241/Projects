package com.te.pcm.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Options {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer optionId;
	
	@Column(nullable = false)
	private String optionTitle;

//	@OneToMany(targetEntity = ProductVariationOptions.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "optionId", referencedColumnName = "optionId")
//	private List<ProductVariationOptions>productVariationOptions; 	
}
