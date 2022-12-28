package com.te.pcmjwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleId;

	@Column(nullable = false, unique = true)
	private String roleName;

	/**
	 * @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL) // private
	 *                      List<User> list; // @OneToOne(fetch = FetchType.LAZY)
	 * @JoinColumn(name = "user_Id",nullable = false)
	 **/
}
