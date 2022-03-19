package com.backend.cargallery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_CUSTOMER")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "TC_NO")
	private Long tcNo;
	
	@Column(name = "DRIVING_LICENCE")
	private String drivingLicence;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "AGE")
	private int age;
	
	@Column(name = "PHONE_NO")
	private Long phoneNo;
	
	@Column(name = "EMAIL")
	private String email;
	
	
	public Customer() {
		super();
	}

	public Customer(Long id, String firstName, String lastName, Long tcNo, String drivingLicence, String address,
			int age, Long phoneNo, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tcNo = tcNo;
		this.drivingLicence = drivingLicence;
		this.address = address;
		this.age = age;
		this.phoneNo = phoneNo;
		this.email = email;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getTcNo() {
		return tcNo;
	}

	public void setTcNo(Long tcNo) {
		this.tcNo = tcNo;
	}

	public String getDrivingLicence() {
		return drivingLicence;
	}

	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
