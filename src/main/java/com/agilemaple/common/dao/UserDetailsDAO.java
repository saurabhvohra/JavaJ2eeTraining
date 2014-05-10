package com.agilemaple.common.dao;

import java.util.List;

import com.agilemaple.common.entity.Contact;
import com.agilemaple.common.entity.UserDetails;

public interface UserDetailsDAO {
	public void addUser(UserDetails user);
	public void removeUser(Integer userid);
	public int updateUser(String password , String username);
	public UserDetails readUsers(String userName,String password);
	public List<UserDetails> listUsers();

}
