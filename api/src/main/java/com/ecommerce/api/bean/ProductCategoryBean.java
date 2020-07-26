package com.ecommerce.api.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="product_category")
@Data
@NoArgsConstructor
@ToString
public class ProductCategoryBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	@NonNull
	@Size(min = 2,max = 32,message = "name must be 2 to 32 chracters long")
	private String name;

	@Column
	@NonNull
	@Size(min = 2,max = 32,message = "category must be 2 to 32 chracters long")
	private String category;

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + ", category=" + category + "]";
	}
	

}
