package com.ecommerce.api.exceptions;

public class ProductDeletionFailed extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductDeletionFailed(String msg) {
		super(msg);
	}
}
