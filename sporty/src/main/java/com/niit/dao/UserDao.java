package com.niit.dao;

import java.util.List;

import com.niit.model.UserModel;

public interface UserDao {
	public boolean addUser(UserModel user);
	public boolean deleteUser(UserModel user);
	public UserModel get(String email);
	public List<UserModel> getAllUsers();
	public void persist(UserModel user);
	public UserModel getUserDetail(String userId);


}
