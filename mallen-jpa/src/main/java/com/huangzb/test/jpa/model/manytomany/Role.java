package com.huangzb.test.jpa.model.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_role")
public class Role {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String name;
	@ManyToMany(cascade={CascadeType.PERSIST})
	@JoinTable( 
			name="t_role_permission",
			joinColumns={@JoinColumn(name="role_id", referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="permission_id", referencedColumnName="id")}
	)
	private Set<Permission> permissions;

	public Role() {
		super();
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Permission> getPermissions() {
		if(null == permissions){
			permissions = new HashSet<Permission>();
		}
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
}
