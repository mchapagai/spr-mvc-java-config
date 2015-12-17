package com.examples.service.data;

import com.examples.model.data.User;

import java.util.List;

public interface UserService {

	List<User> getUsersList();

	void insertUserInfo(User user);

	User getUserByUserId(Integer id);

	void updateUser(User user);

	void deleteUserByUserId(Integer id);

}