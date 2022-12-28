package com.te.pcm.entity;

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

public class Variations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer variationId;
	@Column(nullable = false)
	private String variationTitle;

	@OneToMany(targetEntity = ProductVariations.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "variationId", referencedColumnName = "variationId")
	private List<ProductVariations> produVariations=Lists.newArrayList();
}
