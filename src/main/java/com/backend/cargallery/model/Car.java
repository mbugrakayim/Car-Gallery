package com.backend.cargallery.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "T_CAR")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "PRICE")
	private Long price;
	@Column(name = "BRAND")
	private String brand;
	@Column(name = "MODEL")
	private String model;
	@Column(name = "PLAKA")
	private String plaka;
	@Column(name = "FUEL_TYPE")
	private String fuelType;
	@Column(name = "GEARBOX")
	private String gearBox;
	@Column(name = "BODY_TYPE")
	private String bodyType;
	@Column(name = "DESCRIPTION")
	private String description;
	
	public Car() {
		super();
	}

	public Car(Long price, String brand, String model, String plaka, String fuelType, String gearBox,
			String bodyType, String description) {
		super();
		this.price = price;
		this.brand = brand;
		this.model = model;
		this.plaka = plaka;
		this.fuelType = fuelType;
		this.gearBox = gearBox;
		this.bodyType = bodyType;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlaka() {
		return plaka;
	}

	public void setPlaka(String plaka) {
		this.plaka = plaka;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getGearBox() {
		return gearBox;
	}

	public void setGearBox(String gearBox) {
		this.gearBox = gearBox;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
}
