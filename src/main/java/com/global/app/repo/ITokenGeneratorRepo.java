package com.global.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.global.app.entity.TokenGenarator;

public interface ITokenGeneratorRepo  extends CrudRepository<TokenGenarator, Integer>{

	@Query("FROM TokenGenarator WHERE isActive=true order by tokenNo")
	public List<TokenGenarator> allTokenGenarator();
	
	@Query("FROM TokenGenarator t WHERE t.tId=( SELECT MAX(t2.tId) FROM TokenGenarator t2 WHERE isActive=true)")
	public TokenGenarator getLastToken();

}
