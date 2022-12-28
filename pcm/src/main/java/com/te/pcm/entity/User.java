package com.te.pcm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private String employeeName;
	@Column(nullable = false)
	private String password;
	/**
	 * @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 * @JoinTable(name = "map_users_roles", joinColumns = @JoinColumn(name =
	 *                 "user_fk"), inverseJoinColumns = @JoinColumn(name =
	 *                 "role_fk")) private List<Role> roles = Lists.newArrayList();
	 **/

	@OneToOne(cascade = CascadeType.ALL)
	private Role role;

}
