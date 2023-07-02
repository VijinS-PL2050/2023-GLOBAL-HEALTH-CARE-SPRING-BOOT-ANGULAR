package com.global.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.app.model.SMSSendRequest;
import com.global.app.service.SMSService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Slf4j
public class SMSRestController {
	
	@Autowired
	private SMSService smsService;
	
	
	@PostMapping("/processSMS")
	public String processSMS(@RequestBody SMSSendRequest sendRequest) {
		System.out.println("processSMS Started sendRequest : "+sendRequest.toString());
		return smsService.sendSMS(sendRequest.getDestinationSMSNumber(), sendRequest.getSmsMessages());
		
	}
	
	

}
