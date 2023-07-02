package com.global.app.model;

import lombok.Data;

@Data
public class SMSSendRequest {
	
	private String destinationSMSNumber;
	private String smsMessages;
	
	

}
