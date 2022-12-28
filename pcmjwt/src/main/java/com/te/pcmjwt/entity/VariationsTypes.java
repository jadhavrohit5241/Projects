package com.te.pcmjwt.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class VariationsTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer variationTypeId;
	@Column(nullable = false)
	private String variationTypeTitle;

	@OneToMany(targetEntity = Products.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "variationTypeId", referencedColumnName = "variationTypeId")
	private List<Products> products=Lists.newArrayList();

	@OneToMany(targetEntity = Variations.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "variationTypeId", referencedColumnName = "variationTypeId")
	private List<Variations> variations=Lists.newArrayList();

}