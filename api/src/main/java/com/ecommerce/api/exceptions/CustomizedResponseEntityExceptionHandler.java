
package com.ecommerce.api.exceptions;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@Order(Ordered.HIGHEST_PRECEDENCE)

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	/*protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request";
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	}*/

	//@ExceptionHandler(value= {InternalServerError.class,NotFound.class})
	//@ExceptionHandler(value=Exception.class)
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
	@ExceptionHandler(Exception.class)
	  public ResponseEntity<Object> handleException(Exception e) {
	    //return error(e, HttpStatus.NOT_FOUND, String.valueOf(e.getId()));
		final String message =
		        Optional.of("This failed. Do something properly ").orElse(e.getClass().getSimpleName());
	    return buildResponseEntity(new ApiError(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, message));
	  }
	
	/*protected ResponseEntity<Object> handleHttpNotFound(NotFound ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Not found";
		System.out.println("Http NOT FOUND");
		//return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, error, ex));
		return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, error));
	}
	
	@ExceptionHandler(value = InternalServerError.class)
	protected ResponseEntity<Object> handleHttpInternalServerError(InternalServerError ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Not found";
		System.out.println("Http InternalServerError");
		//return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, error, ex));
		return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, error));
	}
	
	@ExceptionHandler(value = ProductDoesNotExistException.class)
	protected ResponseEntity<Object> handleProductDoesNotExistException(ProductDoesNotExistException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Not found";
		System.out.println("Http InternalServerError");
		//return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, error, ex));
		return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, error));
	}*/
	
	@ExceptionHandler(ProductDoesNotExistException.class)
	  public ResponseEntity<Object> handleProductDoesNotExistException(ProductDoesNotExistException e) {
	    //return error(e, HttpStatus.NOT_FOUND, String.valueOf(e.getId()));
		final String message =
		        Optional.of(e.getMessage()).orElse(e.getClass().getSimpleName());
	    return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, message));
	  }
	
	@ExceptionHandler(ProductCreationException.class)
	  public ResponseEntity<Object> handleProductCreationException(ProductCreationException e) {
		final String message =
		        Optional.of(e.getMessage()).orElse(e.getClass().getSimpleName());
	    return buildResponseEntity(new ApiError(HttpStatus.CONFLICT, message));
	  }
	
	@ExceptionHandler(ProductDeletionFailed.class)
	  public ResponseEntity<Object> handleProductDeletionFailedException(ProductDeletionFailed e) {
		final String message =
		        Optional.of(e.getMessage()).orElse(e.getClass().getSimpleName());
	    return buildResponseEntity(new ApiError(HttpStatus.NO_CONTENT, message));
	  }
	/*@ExceptionHandler(value = ProductDoesNotExistException.class)
	protected ResponseEntity<Object> handleProductDoesNotExistException(ProductDoesNotExistException e,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		final String message =
		        Optional.of(e.getMessage()).orElse(e.getClass().getSimpleName());
	    return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, message));
	}*/
	
	
	/* private <E extends Exception> ResponseEntity<Object> error(
		      final E exception, final HttpStatus httpStatus, final String logRef) {
		    final String message =
		        Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
		    return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, message));
		  }*/


	// other exception handlers below

}
