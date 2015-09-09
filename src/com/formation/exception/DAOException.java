package com.formation.exception;

public class DAOException extends RuntimeException {
	
	private static final long serialVersionUID = -3100941622334840439L;

	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
