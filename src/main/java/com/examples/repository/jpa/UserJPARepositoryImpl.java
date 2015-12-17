package com.examples.repository.jpa;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examples.model.jpa.UserJPA;

@Repository
public class UserJPARepositoryImpl implements UserJPARepository {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @see com.examples.repository.jpa.UserJPARepository#addUserInformation(com.examples.model.jpa.UserJPA)
	 */
	public void addUserInformation(UserJPA user) {
		sessionFactory.getCurrentSession().save(user);
	}

	/**
	 * @see com.examples.repository.jpa.UserJPARepository#listUser()
	 */

	public List<UserJPA> listUser() {
		Query query = sessionFactory.getCurrentSession().createQuery("from UserJPA");
		@SuppressWarnings("unchecked")
		List<UserJPA> list = query.list();
		return list;
	}

	/**
	 * @see com.examples.repository.jpa.UserJPARepository#removeUserByUserId(java.lang.Integer)
	 */
	public void removeUserByUserId(Integer id) {
		UserJPA user = (UserJPA) sessionFactory.getCurrentSession().load(UserJPA.class, id);

		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}
	}

	/**
	 * @see com.examples.repository.jpa.UserJPARepository#insertOrUpdateUser(com.examples.model.jpa.UserJPA)
	 */
	public void insertOrUpdateUser(UserJPA user) {
		UserJPA updateUser = getUserByUserId(user.getId());
		updateUser.setLastname(user.getLastname());
		updateUser.setFirstname(user.getFirstname());
		updateUser.setBirthdate(user.getBirthdate());
		updateUser.setCountry(user.getCountry());
		updateUser.setEmail(user.getEmail());

		sessionFactory.getCurrentSession().update(updateUser);
	}

	/**
	 * @see
	 * com.examples.repository.jpa.UserJPARepository#getUserByUserId(java.lang.Integer)
	 */
	public UserJPA getUserByUserId(Integer id) {
		UserJPA users = (UserJPA) sessionFactory.getCurrentSession().get(UserJPA.class, id);
		return users;
	}

	/**
	 * @see com.examples.repository.jpa.UserJPARepository#searchUser(java.lang.String)
	 */
	public UserJPA searchUser(String where) {
		Query query = sessionFactory.getCurrentSession().createQuery("from UserJPA where" + where);
		UserJPA user = (UserJPA) query.uniqueResult();
		return user;
	}

}
