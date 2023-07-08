package com.global.app.service;

import java.util.List;

import com.global.app.common.APIResponse;
import com.global.app.entity.User;

public interface ILoginSevice {

	public  APIResponse findUserByNameAndPassword(String userName,String password);
	
	public List<User> getAllUser();
}
