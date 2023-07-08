package com.global.app.service;

import java.util.List;

import com.global.app.entity.TokenGenarator;

public interface ITokenGeneratorService {
	
	public void insertUpdateTokenGenarator(TokenGenarator tokenGenarator);
	public List<TokenGenarator> allTokenGenarator();
	public void deleteTokenGenarator(TokenGenarator tokenGenarator);
	public TokenGenarator getLastToken();
	public TokenGenarator getToken(Integer tId);

}
