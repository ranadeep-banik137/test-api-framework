package com.project.app.api_test_v1.exceptions;

import java.util.logging.Logger;

@SuppressWarnings("serial")
public class ImproperJsonFormatException extends Exception {
	
	private String message;
	private static Logger LOGGER = Logger.getLogger(ImproperJsonFormatException.class.getName());
	
	public ImproperJsonFormatException() {
		ImproperJsonFormatException.LOGGER.info("Improper Json Format Exception");
	}
	
	public ImproperJsonFormatException(final String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}
}
