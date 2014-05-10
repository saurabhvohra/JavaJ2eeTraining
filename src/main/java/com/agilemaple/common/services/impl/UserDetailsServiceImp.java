package com.agilemaple.common.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agilemaple.common.dao.UserDetailsDAO;
import com.agilemaple.common.dao.UserInformationDAO;
import com.agilemaple.common.entity.UserDetails;
import com.agilemaple.common.services.UserDetailsService;

@Service
public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	private UserDetailsDAO userDetailsDAO;
	
	@Override
	@Transactional
	public void addUser(UserDetails user) {
		userDetailsDAO.addUser(user);
		
	}

	@Override
	@Transactional
	public void removeUser(Integer userid) {
		userDetailsDAO.removeUser(userid);
		
	}

	@Override
	@Transactional
	public int updateUser(String password, String username) {
		return userDetailsDAO.updateUser(password, username);
		
	}

	@Override
	@Transactional
	public UserDetails readUsers(String userName, String password) {
		return userDetailsDAO.readUsers(userName,password);
	}

	@Override
	@Transactional
	public List<UserDetails> listUsers() {
	 return userDetailsDAO.listUsers();
	}
	

}
