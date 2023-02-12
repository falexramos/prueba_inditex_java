package com.inditex.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class ErrorMessageDTO implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public ErrorMessageDTO(String message) {
		super();
		this.message = message;
	}

	private String message;
}
