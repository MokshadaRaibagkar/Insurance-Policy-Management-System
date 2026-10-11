package com.insurance.exception;

public class DuplicatePolicyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DuplicatePolicyException(String message) {
		super(message);
	}
}
