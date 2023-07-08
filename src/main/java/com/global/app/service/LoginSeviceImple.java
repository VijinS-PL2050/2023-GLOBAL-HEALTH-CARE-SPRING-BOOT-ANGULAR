package com.global.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.app.common.APIResponse;
import com.global.app.entity.User;
import com.global.app.repo.ILoginRepo;
import com.global.app.util.JwtUtil;

@Service
public class LoginSeviceImple implements ILoginSevice {

	@Autowired
	private ILoginRepo loginRepo;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public APIResponse findUserByNameAndPassword(String userName, String password) {
		APIResponse apiResponse = new APIResponse();

		// verify user exist or not
		User user = loginRepo.findUserByNameAndPassword(userName, password);
		if (user == null) {
			apiResponse.setData("User Login Failed....!");
			return apiResponse;
		}

		// credentails are valid generate token
		//String token = jwtUtil.generateJwt(user);

		// Storing more details and token
		Map<String, Object> data = new HashMap<String, Object>();
		//data.put("AccessToken", token);
		data.put("rId", user.getRId());
		data.put("uId", user.getUId());
		data.put("UserId", user.getUserId());
		data.put("UserName", user.getUserName());
		apiResponse.setData(data);
		apiResponse.setStatus(200);
		return apiResponse;
	}

	@Override
	public List<User> getAllUser() {
		
		return (List<User>) loginRepo.findAll();
	}

}
