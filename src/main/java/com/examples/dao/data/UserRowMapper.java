package com.examples.dao.data;

import com.examples.model.data.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

	static final String USER_ID = "id";
	static final String USER_LAST_NAME = "last_name";
	static final String USER_FIRST_NAME = "first_name";
	static final String USER_CITY = "city";
	static final String USER_ZIP = "postal_code";
	static final String USER_COUNTRY = "country";
	static final String USER_EMAIL = "email";

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User details = new User();
		details.setId(rs.getInt(USER_ID));
		details.setLastName(rs.getString(USER_LAST_NAME));
		details.setFirstName(rs.getString(USER_FIRST_NAME));
		details.setCity(rs.getString(USER_CITY));
		details.setZip(rs.getString(USER_ZIP));
		details.setCountry(rs.getString(USER_COUNTRY));
		details.setEmail(rs.getString(USER_EMAIL));
		return details;
	}

}