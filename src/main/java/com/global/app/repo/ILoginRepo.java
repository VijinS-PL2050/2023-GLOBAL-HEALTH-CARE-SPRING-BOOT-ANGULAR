package com.global.app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.global.app.entity.User;

public interface ILoginRepo extends CrudRepository<User, Integer> {

	@Query("FROM User WHERE userName=?1 AND password=?2 AND isActive=true")
	public User findUserByNameAndPassword(String userName,String password);
}
