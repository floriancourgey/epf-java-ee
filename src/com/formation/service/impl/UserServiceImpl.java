package com.formation.service.impl;

import java.util.List;

import com.formation.dao.UserDao;
import com.formation.dao.impl.UserDaoImpl;
import com.formation.entity.User;
import com.formation.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	private static UserService INSTANCE = null;
	
	private UserServiceImpl() {
		this.userDao = UserDaoImpl.getInstance();
	}
	
	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public User getById(Long id) {
		return userDao.getById(id);
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);
	}
	
	public static UserService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UserServiceImpl();
		}
		return INSTANCE;
	}
	
}
