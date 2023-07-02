package com.global.app.common;

import lombok.Data;

@Data
public class APIResponse {
	
	private Integer status;//to store response from server
	private Object data;
	private Object error;//to store error messages
	
	

}
