/**
 * 
 */
package com.sogeti.voucher.exception;

/**
 * @author vkalyana
 *
 */
public class EmployeeNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 * @param cause
	 */
	public EmployeeNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public EmployeeNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public EmployeeNotFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
