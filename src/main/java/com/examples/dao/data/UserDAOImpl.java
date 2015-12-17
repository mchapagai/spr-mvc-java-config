package com.examples.dao.data;

import com.examples.model.data.User;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "userDAO")
public class UserDAOImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	static final String DATASOURCE_BEAN = "dataSource";
	private static final String GET_USERS_LIST = "select * from users";
	private static final String INSERT_USERS_INFO = "insert into users (last_name, first_name, city, postal_code, country, email)"
			+ "values(?,?,?,?,?,?)";
	private static final String GET_USER_BY_USERID = "select * from users where id=?";
	private static final String UPDATE_USER_DETAILS = "update users set last_name=?, first_name=?, city=?, postal_code=?, country=?, email=? where id=?";
	private static final String DELETE_USER_DETAILS = "delete from users where id=?";

	/**
	 * @param dataSource JdbcTemplate
	 * @Qualifier
	 */
	@Autowired
	public void createTemplate(@Qualifier(value = DATASOURCE_BEAN) DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * @see com.examples.data.dao.UserDAO#getUsersList() Gets the data from the
	 *      Users table
	 */
	public List<User> getUsersList() {
		List<User> details = new ArrayList<User>();
		details = jdbcTemplate.query(GET_USERS_LIST, new UserRowMapper());
		return details;
	}

	public void insertUserInfo(User user) {
		jdbcTemplate.update(INSERT_USERS_INFO, new Object[] { user.getLastName(), user.getFirstName(), user.getCity(),
				user.getZip(), user.getCountry(), user.getEmail() });

	}

	public User getUserByUserId(Integer id) {
		if (id == null) {
			return null;
		}

		try {
			User user = (User) jdbcTemplate.queryForObject(GET_USER_BY_USERID, new UserRowMapper(), id);
			return user;
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}

	/**
	 * @see com.examples.data.dao.UserDAO#updateUser(com.examples.data.model.User)
	 */

	public void updateUser(User user) {
		jdbcTemplate.update(UPDATE_USER_DETAILS, new Object[] { user.getLastName(), user.getFirstName(), user.getCity(),
				user.getZip(), user.getCountry(), user.getEmail(), user.getId() });
	}

	/**
	 * @see com.examples.data.dao.UserDAO#deleteUserByUserId(java.lang.Integer)
	 */
	public void deleteUserByUserId(Integer id) {
		jdbcTemplate.update(DELETE_USER_DETAILS, id);
	}

	/**
	 * @param jdbcTemplate
	 */
	public void setJdbcTempate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}