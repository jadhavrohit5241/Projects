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

public class OptionTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer optionTypeId;
	@Column(nullable = false)
	private String optionTypeTitle;

	@OneToMany(targetEntity = Products.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "optionTypeId", referencedColumnName = "optionTypeId")
	private List<Products> productList=Lists.newArrayList();

	@OneToMany(targetEntity = Options.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "optionTypeId", referencedColumnName = "optionTypeId")
	private List<Options> options=Lists.newArrayList();

}
