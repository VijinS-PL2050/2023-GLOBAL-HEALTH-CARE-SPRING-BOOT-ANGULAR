package com.global.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.app.common.APIResponse;
import com.global.app.entity.User;
import com.global.app.service.ILoginSevice;

@CrossOrigin // inorder eliminate port number conflict
@RestController //@Controller + @configuration
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private ILoginSevice loginSevice;
	
	@GetMapping("/login/{userName}&{password}")
	public ResponseEntity<APIResponse> findUserByNameAndPassword(@PathVariable String userName,@PathVariable String password) {

		System.out.println("oiuytr");
		APIResponse apiResponse=loginSevice.findUserByNameAndPassword(userName, password);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		
	}
	
	@GetMapping("/login")
	public List<User> getAll(){
		return loginSevice.getAllUser();
		
	}
}
