package com.backend.cargallery.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_RENTAL")
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@OneToOne
	@JoinColumn(name = "CAR_ID",referencedColumnName = "id")
	private Car carId;
	@OneToOne
	@JoinColumn(name = "CUSTOMER_ID",referencedColumnName = "id")
	private Customer customerId;
	@OneToOne
	@JoinColumn(name = "EMPLOYEE_ID",referencedColumnName = "id")
	private Employee employeeId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RENT_DATE")
	private Date rentDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RETURN_DATE")
	private Date returnDate;
	@Column(name = "PRICE")
	private Long price;
	@Column(name = "DESCRIPTION")
	private String description;

	public Rental() {
		super();
	}

	public Rental(Long id, Car carId, Customer customerId, Employee employeeId, Date rentDate, Date returnDate,
			Long price, String description) {
		super();
		this.id = id;
		this.carId = carId;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.price = price;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Car getCarId() {
		return carId;
	}

	public void setCarId(Car carId) {
		this.carId = carId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public Employee getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Rental [id=" + id + ", carId=" + carId + ", customerId=" + customerId + ", employeeId=" + employeeId
				+ ", rentDate=" + rentDate + ", returnDate=" + returnDate + ", price=" + price + ", description="
				+ description + "]";
	}
	
	

}
