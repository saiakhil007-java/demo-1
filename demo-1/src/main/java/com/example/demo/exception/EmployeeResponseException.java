
package com.example.demo.exception;

public class EmployeeResponseException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeResponseException() {
        super("Employee-related error occurred.");
    }

    public EmployeeResponseException(String message) {
        super(message);
    }

    public EmployeeResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeResponseException(Throwable cause) {
        super(cause);
    }
}

