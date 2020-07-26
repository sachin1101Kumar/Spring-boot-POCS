package com.ecommerce.api.exceptions;

public class ProductCategoryDoesNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	public ProductCategoryDoesNotExistException(String message) {
		super(message);
	} 
}
