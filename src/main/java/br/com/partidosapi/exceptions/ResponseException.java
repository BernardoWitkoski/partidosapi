package br.com.partidosapi.exceptions;

import java.time.LocalDateTime;

public class ResponseException {

	
	private Integer status;
	
	private String error;
	
	private String message;
	
	private LocalDateTime timestamp;
	
}
