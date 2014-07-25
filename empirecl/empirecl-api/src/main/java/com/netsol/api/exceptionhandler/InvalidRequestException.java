/**
 * 
 */
package com.netsol.api.exceptionhandler;

import org.springframework.validation.Errors;

/**
 * @author Harmeet Singh(Taara)
 *
 */
public class InvalidRequestException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1121735007796423936L;
	
	private Errors errors;
	
	public InvalidRequestException(String message, Errors errors) {
		super(message);
		this.errors = errors;
	}
	
	public Errors getErrors(){
		return errors;
	}
}
