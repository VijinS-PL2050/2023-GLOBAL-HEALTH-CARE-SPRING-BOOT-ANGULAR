package com.global.app.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Component;

@Component
public class Validation {
	
	public Boolean isNameValid(String name) {
		Boolean bool=false;
		try {
			Pattern namePattern=Pattern.compile("[^A-Za-z ]");
			Matcher nameMatcher=namePattern.matcher(name);
			
			if(nameMatcher.find()) {
				throw new InvalidNameException("Invalid name");
			}else {
				bool=true;
			}
		}catch(InvalidNameException e) {
			System.out.println(e);
			e.getMessage();
		}
		return bool;
		
	}

}
