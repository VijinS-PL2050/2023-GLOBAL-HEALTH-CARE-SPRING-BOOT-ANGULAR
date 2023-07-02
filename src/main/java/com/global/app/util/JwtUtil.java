package com.global.app.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.global.app.common.AccessDeniedException;
import com.global.app.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	
	//secret Key
	private static String secret="THIS_IS_JAVA";
	
	//expiration time 
	private static long expiryDuration=60*60;
	
	//generate token: header,payload,signature
	
	public String generateJwt(User user) {
		
		long milliTime=System.currentTimeMillis();
		long expiryTime=milliTime+expiryDuration*1000;
		
		//set issuedTime and expiryTime
		Date issuedAt=new Date(milliTime);
		Date expiryAt=new Date(expiryTime);
		
		//claims
		Claims claim=Jwts.claims().setIssuer(String.valueOf(user.getUserId())).setIssuedAt(issuedAt).setExpiration(expiryAt);
		
		//generate jwt using 
		return Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS512, secret).compact();
		
	}
	
	//checking token valid or access denied
	public Claims verify(String authorization) {
		try{
			Claims claim=Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
			return claim;
		}catch(Exception e) {
			throw new AccessDeniedException("Sorry! Acess denied !!");
		}
				
	}
}
