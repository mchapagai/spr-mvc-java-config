package com.examples.service.data;

import com.examples.dao.data.UserDAO;
import com.examples.model.data.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> getUsersList() {
		return userDAO.getUsersList();
	}

	@Override
	public void insertUserInfo(User user) {
		userDAO.insertUserInfo(user);
	}

	@Override
	public User getUserByUserId(Integer id) {
		return userDAO.getUserByUserId(id);
	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Override
	public void deleteUserByUserId(Integer id) {
		userDAO.deleteUserByUserId(id);
	}

}