package com.cg.ems.Exception;

public class EMSNotFoundException extends Exception
{

	private static final long serialVersionUID = 1L;

	public EMSNotFoundException() {
		super();
	}

	public EMSNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EMSNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EMSNotFoundException(String message) {
		super(message);
	}

	public EMSNotFoundException(Throwable cause) {
		super(cause);
	}

}
