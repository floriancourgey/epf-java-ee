package com.floriancourgey.java.cours1.models;

import java.util.Date;
import javax.persistence.*;

import com.floriancourgey.java.cours1.models.Company;

@Entity
@Table(name = "computer")
public class Computer {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "introduced")
	private Date introduced;
	
	@Column(name = "discontinued")
	private Date discontinued;
	
	@ManyToOne(targetEntity = Company.class)
	private Company company;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getIntroduced() {
		return introduced;
	}
	public void setIntroduced(Date introduced) {
		this.introduced = introduced;
	}
	public Date getDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(Date discontinued) {
		this.discontinued = discontinued;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
