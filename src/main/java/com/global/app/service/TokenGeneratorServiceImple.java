package com.global.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.app.entity.TokenGenarator;
import com.global.app.repo.ITokenGeneratorRepo;

@Service
public class TokenGeneratorServiceImple implements ITokenGeneratorService {

	private ITokenGeneratorRepo repo;

	@Autowired
	public TokenGeneratorServiceImple(ITokenGeneratorRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void insertUpdateTokenGenarator(TokenGenarator tokenGenarator) {
		System.out.println("i m gen");
		repo.save(tokenGenarator);

	}

	@Override
	public List<TokenGenarator> allTokenGenarator() {

		return repo.allTokenGenarator();
	}

	@Override
	public void deleteTokenGenarator(TokenGenarator tokenGenarator) {
		tokenGenarator.setIsActive(false);
		repo.save(tokenGenarator);

	}

	@Override
	public TokenGenarator getLastToken() {

		return repo.getLastToken();
	}

	@Override
	public TokenGenarator getToken(Integer tId) {

		return repo.findById(tId).orElseThrow(() -> new RuntimeException("Token not found for " + tId));
	}

}
