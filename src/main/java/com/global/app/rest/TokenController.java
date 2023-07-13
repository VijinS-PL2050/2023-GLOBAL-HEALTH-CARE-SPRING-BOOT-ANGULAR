package com.global.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.app.entity.TokenGenarator;
import com.global.app.service.IDoctorAndDepartmentService;
import com.global.app.service.ITokenService;

@CrossOrigin
@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class TokenController {
	@Autowired
	private ITokenService tokenservice;
	
	@Autowired
	private IDoctorAndDepartmentService doctorAndDepartmentService;
	
	// listing
		@GetMapping("/token/{uId}")
		public List<TokenGenarator> getToken(@PathVariable Integer uId) {
			Integer doId=doctorAndDepartmentService.getDoctorDetailsByuId(uId).getDoId();
			System.out.println("do id -"+doId);
			return tokenservice.getToken(doId);
		}
		
	
}
