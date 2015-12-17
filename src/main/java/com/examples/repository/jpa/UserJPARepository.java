package com.examples.repository.jpa;

import java.util.List;

import com.examples.model.jpa.UserJPA;

public interface UserJPARepository {

	void addUserInformation(UserJPA user);

	List<UserJPA> listUser();

	void removeUserByUserId(Integer id);

	void insertOrUpdateUser(UserJPA user);

	UserJPA getUserByUserId(Integer id);

	UserJPA searchUser(String where);

}
