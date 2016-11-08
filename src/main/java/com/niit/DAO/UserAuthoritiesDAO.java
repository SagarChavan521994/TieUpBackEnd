package com.niit.DAO;

import com.niit.model.UserAuthorities;

public interface UserAuthoritiesDAO {

	void saveOrUpdateUserAuthority(UserAuthorities userAuthorities);
	
	void deleteUserAuthority(String email);
	
	UserAuthorities getUserAuthority(String userId);
}
