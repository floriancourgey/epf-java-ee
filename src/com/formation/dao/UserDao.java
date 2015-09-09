package com.formation.dao;

import java.util.List;

import com.formation.entity.User;

public interface UserDao {
	List<User> getAll();
	
	User getById(Long id);
	
	void insert(User user);
}
