package com.global.app.service;

import java.util.List;

import com.global.app.entity.TokenGenarator;

public interface ITokenService {
	//list
		public List<TokenGenarator>getToken(Integer doId);
		
}
