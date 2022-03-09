package com.hero.exception;

public class SuperheroException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7863409826588351586L;

	public SuperheroException() {
		super();
	}

	public SuperheroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SuperheroException(String message, Throwable cause) {
		super(message, cause);
	}

	public SuperheroException(String message) {
		super(message);
	}

	public SuperheroException(Throwable cause) {
		super(cause);
	}

	
	
}
