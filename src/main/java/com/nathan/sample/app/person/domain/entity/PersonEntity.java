package com.nathan.sample.app.person.domain.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Person Entity
 * @author Saravanan Renganthan
 *
 */

@Entity
@Table (name = "PERSON")
public class PersonEntity implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "PERSON_ID")
	private Long id;
	
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column (name = "LAST_NAME")
	private String lastName;
	
	
	@Column (name = "DESCRIPTION")
	private String description;
	
	@ManyToOne (fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	private DepartmentEntity department;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	 

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public DepartmentEntity getDepartment() {
		return department;
	}


	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

}
