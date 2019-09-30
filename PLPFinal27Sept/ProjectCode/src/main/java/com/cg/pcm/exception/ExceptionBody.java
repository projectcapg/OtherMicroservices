package com.cg.pcm.exception;

//Exception Body class in case of id not found exception
public class ExceptionBody {
	private String timestamp;
	private String message;
	private String details;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public ExceptionBody(String timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public ExceptionBody() {
		super();
	}

	@Override
	public String toString() {
		return "ErrorInfo [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}
}
