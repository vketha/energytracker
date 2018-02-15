/**
 * 
 */
package com.java.energytracker.commons.dto;

/**
 * 
 * @author vijayk
 *
 * @param <T>
 */
public class ResponseDto<T> {
	
	private String status;
	private String message;
	private T content;
	
	public ResponseDto(String status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public ResponseDto(String status, String message, T content) {
		this(status, message);
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
}
