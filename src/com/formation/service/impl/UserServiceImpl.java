package com.formation.service.impl;

import java.util.List;

import com.formation.dao.UserDao;
import com.formation.dao.impl.UserDaoImpl;
import com.formation.entity.User;
import com.formation.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserServiceImpl() {
		this.userDao = new UserDaoImpl();
	}
	
	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public User getById(Long id) {
		return userDao.getById(id);
	}

}
