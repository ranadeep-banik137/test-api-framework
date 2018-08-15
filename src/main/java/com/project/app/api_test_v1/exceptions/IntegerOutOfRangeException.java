package com.project.app.api_test_v1.exceptions;

import java.util.logging.Logger;

@SuppressWarnings("serial")
public class IntegerOutOfRangeException extends Exception {
	
	private String message;
	private static Logger LOGGER = Logger.getLogger(IntegerOutOfRangeException.class.getName());
	
	public IntegerOutOfRangeException() {
		IntegerOutOfRangeException.LOGGER.info("Integer out of range exception");
	}
	
	public IntegerOutOfRangeException(final String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}
}
