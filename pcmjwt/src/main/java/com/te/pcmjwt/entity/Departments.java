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

import org.checkerframework.common.aliasing.qual.Unique;

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
public class Departments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer departmentId;
	@Column(nullable = false)
	@Unique
	private String departmentTitle;
	@OneToMany(targetEntity = Products.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
	private List<Products> productList=Lists.newArrayList();
	@OneToMany(targetEntity = Categories.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
	private List<Categories> categoryList=Lists.newArrayList();

	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	private List<Employee> employees=Lists.newArrayList();

}
