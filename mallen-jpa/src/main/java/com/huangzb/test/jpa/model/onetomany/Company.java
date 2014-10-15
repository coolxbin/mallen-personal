package com.huangzb.test.jpa.model.onetomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_company")
public class Company {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String name;
	@OneToMany(/*mappedBy="company", */cascade={CascadeType.ALL})
	private Set<Person>	persons;

	public Company() {
		super();
	}

	public Company(String name) {
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

	public Set<Person> getPersons() {
		if(persons == null){
			persons = new HashSet<Person>();
		}
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

}
