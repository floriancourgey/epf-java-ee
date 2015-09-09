package com.formation.service;

import java.util.List;
import com.formation.entity.User;

public interface UserService {
	
	List<User> getAll();
	
	User getById(Long id);

}
