package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User>{
	
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setAccount(rs.getString("account"));
		user.setName(rs.getString("name"));
		user.setGender(rs.getString("gender"));
		user.setBirthday(rs.getString("birthday"));
		user.setMailbox(rs.getString("mailbox"));
		user.setPersonality(rs.getString("personality"));
		user.setPortrait(rs.getString("portrait"));
		return user;
	}
}
