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

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="product_category")
@Data
@NoArgsConstructor
@ToString
public class ProductCategory {
	
	@Id
	//productcategory_seq
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productcategory_seq")
    @SequenceGenerator(sequenceName = "productcategory_seq", allocationSize = 1, name = "productcategory_seq")
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
