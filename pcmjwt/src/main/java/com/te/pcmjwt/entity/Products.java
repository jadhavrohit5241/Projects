package com.te.pcmjwt.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	@Column(nullable = false)
	private String productTitle;
	
	private String productsQualityReport;
	
	private Integer productTotalStock;	
	@JsonFormat(pattern = "dd-mm-yyyy")
	//@Temporal(TemporalType.DATE	)
	private Date expDate;

	@ManyToOne
	private Departments departments;
	
	@ManyToOne
	private Categories categories;
	
	@ManyToOne
	private OptionTypes optionTypes;
	
	@ManyToOne
	private VariationsTypes variationsTypes;

	
//	@OneToMany(targetEntity = OptionTypes.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "productId", referencedColumnName = "productId")
//	private List<OptionTypes> optionTypes=Lists.newArrayList();
//
	
	@OneToMany(targetEntity = ProductVariations.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "productId", referencedColumnName = "productId")
	private List<ProductVariations> productVariations=Lists.newArrayList();

}
