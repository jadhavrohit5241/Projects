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

public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer catagoryId;
	@Column(nullable = false)
	private String catagoryTitle;

	@OneToMany(targetEntity = Products.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "catagoryId", referencedColumnName = "catagoryId")
	private List<Products> products=Lists.newArrayList();

	@OneToMany(targetEntity = VariationsTypes.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "catagoryId", referencedColumnName = "catagoryId")
	private List<VariationsTypes> variationsTypes=Lists.newArrayList();

	@OneToMany(targetEntity = OptionTypes.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "catagoryId", referencedColumnName = "catagoryId")
	private List<OptionTypes> optionTypes=Lists.newArrayList();
}
