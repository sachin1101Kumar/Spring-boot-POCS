package com.ecommerce.api.exceptions;

public class ProductCreationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductCreationException(String message) {
		super(message);
	}

}
