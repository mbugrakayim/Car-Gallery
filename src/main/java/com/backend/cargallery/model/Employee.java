package com.backend.cargallery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "T_EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name ="LAST_NAME")
	private String lastName;
	
	@Column(name = "SALARY")
	private Long salary;
	
	@Column(name = "PRIZE")
	private Long prize;
	
	@Column(name =  "PHONE_NO")
	private Long phoneNo;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Lob
	@Column(name = "IMAGES")
	private byte[] images;
	
	public Employee() {
		super();
	}


	public Employee(String firstName, String lastName, Long salary, Long prize, Long phoneNo, String address,
			byte[] images) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.prize = prize;
		this.phoneNo = phoneNo;
		this.address = address;
		this.images = images;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Long getPrize() {
		return prize;
	}

	public void setPrize(Long prize) {
		this.prize = prize;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getImages() {
		return images;
	}

	public void setImages(byte[] images) {
		this.images = images;
	}

	public Long getId() {
		return id;
	}

	

}
