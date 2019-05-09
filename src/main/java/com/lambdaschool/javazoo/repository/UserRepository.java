package com.lambdaschool.javazoo.repository;

import com.lambdaschool.javazoo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
	User findByUsername(String username);
}