package com.example.springbootmongodb.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String name;
	private String brand;
	private Date manufacturingYear;
	private int warrantyupto;
	private String ownerString;


	public Product() {
	}

	public Product(String name, String brand, Date manufacturingYear, int warrantyupto, String ownerString) {
		this.name = name;
		this.brand = brand;
		this.manufacturingYear = manufacturingYear;
		this.warrantyupto = warrantyupto;
		this.ownerString = ownerString;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(Date manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public int getWarrantyupto() {
		return warrantyupto;
	}

	public void setWarrantyupto(int warrantyupto) {
		this.warrantyupto = warrantyupto;
	}

	public String getOwnerString() {
		return ownerString;
	}

	public void setOwnerString(String ownerString) {
		this.ownerString = ownerString;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", manufacturingYear=" + manufacturingYear
				+ ", warrantyupto=" + warrantyupto + ", ownerString=" + ownerString + "]";
	}

	



}
