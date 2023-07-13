package com.global.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.global.app.entity.TokenGenarator;

public interface ITokenRepo extends  CrudRepository<TokenGenarator,Integer> {
	@Query("FROM TokenGenarator WHERE doId=?1 AND isActive=true")
	public List<TokenGenarator> getToken(Integer doId) ;	

}
