package com.ecommerce.api.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Product")
@NoArgsConstructor
@AllArgsConstructor
public class Product{

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_ID_SEQ")
    @SequenceGenerator(sequenceName = "PRODUCT_ID_SEQ", allocationSize = 1, name = "PRODUCT_ID_SEQ")
	private Integer id;
    
	@Column
	@NonNull
	@Size(min = 2,max = 32,message = "category must be 2 to 32 chracters long")
	private String name;
	
	@Column
	@NonNull
	@Size(min = 2,max = 32,message = "category must be 2 to 32 chracters long")
	private String category;
	
	@Column
	@NonNull
	@Size(min = 2,max = 32,message = "Owner name must be 2 to 32 chracters long")
	private String owner;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", owner=" + owner + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}

