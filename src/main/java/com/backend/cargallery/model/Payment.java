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
@Table(name = "T_PAYMENT")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "EMPLOYEE_ID",referencedColumnName = "id")
	private Employee employeeId;
	@OneToOne
	@JoinColumn(name = "CUSTOMER_ID",referencedColumnName = "id")
	private Customer customerId;
	@OneToOne
	@JoinColumn(name = "RENTAL_ID",referencedColumnName = "id")
	private Rental rentalId;
	@Temporal(TemporalType.DATE)
	@Column(name = "PAYMENT_DATE")
	private Date paymentDate;
	@Column(name = "AMOUNT")
	private Long amount;
	@Column(name = "PAYMENT_DESC")
	private String description;
	
	public Payment() {
		super();
	}

	
	public Payment(Long id, Employee employeeId, Customer customerId, Rental rentalId, Date paymentDate, Long amount,
			String description) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.customerId = customerId;
		this.rentalId = rentalId;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.description = description;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Employee getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}


	public Customer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}


	public Rental getRentalId() {
		return rentalId;
	}


	public void setRentalId(Rental rentalId) {
		this.rentalId = rentalId;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public Long getAmount() {
		return amount;
	}


	public void setAmount(Long amount) {
		this.amount = amount;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Payment [id=" + id + ", employeeId=" + employeeId + ", customerId=" + customerId + ", rentalId="
				+ rentalId + ", paymentDate=" + paymentDate + ", amount=" + amount + ", description=" + description
				+ "]";
	}
	

}
