package com.backend.cargallery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "T_CAR_IMAGES")
public class CarImages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	private String name;
	
	private String type;

	@Lob
	@Column(name = "IMAGES")
	private byte[] images;
	
	@ManyToOne
	@JoinColumn(name = "CAR_ID", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Car carId;

	public CarImages() {
		super();
	}

	
	public CarImages(String name, String type, byte[] images, Car carId) {
		super();
		this.name = name;
		this.type = type;
		this.images = images;
		this.carId = carId;
	}



	public Long getId() {
		return id;
	}

	public Car getCarId() {
		return carId;
	}

	public void setCarId(Car carId) {
		this.carId = carId;
	}

	public byte[] getImages() {
		return images;
	}

	public void setImages(byte[] images) {
		this.images = images;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
