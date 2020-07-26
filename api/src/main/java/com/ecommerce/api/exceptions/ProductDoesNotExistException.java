package com.ecommerce.api.exceptions;

//@Getter
public class ProductDoesNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	public ProductDoesNotExistException(String message) {
		super(message);
	}
	
	private Integer id;
	
	public ProductDoesNotExistException(Integer id) {
		super("Product could not be found with id: " + id);
	    this.id = id;
	}

	public Integer getId() {
		return id;
	} 
}
