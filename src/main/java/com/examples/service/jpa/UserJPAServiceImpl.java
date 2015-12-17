package com.examples.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examples.model.jpa.UserJPA;
import com.examples.repository.jpa.UserJPARepository;

@Service
@Transactional
public class UserJPAServiceImpl implements UserJPAService {

	@Autowired
	private UserJPARepository userJPARepository;

	public void addUserInformation(UserJPA user) {
		userJPARepository.addUserInformation(user);
	}

	@Override
	public List<UserJPA> listUser() {
		return userJPARepository.listUser();
	}

	@Override
	public void removeUserByUserId(Integer id) {
		userJPARepository.removeUserByUserId(id);
	}

	@Override
	public void insertOrUpdateUser(UserJPA user) {
		userJPARepository.insertOrUpdateUser(user);
	}

	@Override
	public UserJPA getUserByUserId(Integer id) {
		return userJPARepository.getUserByUserId(id);
	}

	@Override
	public UserJPA searchUser(String where) {
		return userJPARepository.searchUser(where);
	}

}