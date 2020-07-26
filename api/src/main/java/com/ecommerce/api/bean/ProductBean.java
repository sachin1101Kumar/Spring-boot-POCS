package com.ecommerce.api.bean;

//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class ProductBean{
	
	

	public ProductBean() {
		//super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ProductBean(Integer id, String name, String category, String owner) {
		//super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.owner = owner;
	}



	private Integer id;
    
	private String name;
	
	private String category;
	
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

