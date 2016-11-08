package com.niit.DAO;

import com.niit.model.Users;

public interface UserDAO {

	void saveOrUpdateUser(Users user);
	
	void deleteUser(String email);
	
	Users getUser(String userId);
	
}
