package com.examples.dao.data;

import com.examples.model.data.User;

import java.util.List;

public interface UserDAO {

	List<User> getUsersList();

	void insertUserInfo(User user);

	User getUserByUserId(Integer id);

	void updateUser(User user);

	void deleteUserByUserId(Integer id);

}