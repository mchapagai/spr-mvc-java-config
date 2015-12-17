package com.examples.service.jpa;

import java.util.List;

import com.examples.model.jpa.UserJPA;

public interface UserJPAService {

	void addUserInformation(UserJPA user);

	List<UserJPA> listUser();

	void removeUserByUserId(Integer id);

	void insertOrUpdateUser(UserJPA user);

	UserJPA getUserByUserId(Integer id);

	UserJPA searchUser(String where);

}