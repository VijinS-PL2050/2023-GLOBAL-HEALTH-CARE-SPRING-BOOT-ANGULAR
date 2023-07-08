package com.global.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.app.entity.TokenGenarator;
import com.global.app.service.ITokenGeneratorService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Slf4j
public class TokenGeneratorRestController {
	
	@Autowired
	private ITokenGeneratorService tokenGeneratorService;
	
	@GetMapping("/tokens")
	public List<TokenGenarator> allTokenGenerators(){
		return tokenGeneratorService.allTokenGenarator();
		
	}
	
	@DeleteMapping("/tokens/{tId}")
	public void deleteTokenGenerator(@PathVariable Integer tId) {
		tokenGeneratorService.deleteTokenGenarator(tokenGeneratorService.getToken(tId));
	}
	
	@GetMapping("/tokenGen")
	public TokenGenarator getTokenGenerators(){
		return tokenGeneratorService.getLastToken();
		
	}

}
