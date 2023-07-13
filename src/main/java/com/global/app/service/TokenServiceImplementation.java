package com.global.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.app.entity.TokenGenarator;
import com.global.app.repo.ITokenRepo;
@Service
public class TokenServiceImplementation implements ITokenService{


 @Autowired
	private ITokenRepo tokenrepo;


	@Override
	public List<TokenGenarator> getToken(Integer doId) {
		// TODO Auto-generated method stub
		return tokenrepo.getToken(doId);
	}
}