package dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class FollowJDBC implements FollowDao{
	private JdbcTemplate jdbcTemplateObject;
	
	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	public void addfollow(String account, String coveraccount, String name, String covername) {
		//关注
		
	}

	public void deletefollow(String account, String coveraccount) {
		// 取消关注
		
	}

	public List<Follow> lookfollow(String account) {
		// 查看关注
		String SQL = "select * from follow where account = '"+ account +"'";
		List<Follow> follows = jdbcTemplateObject.query(SQL, new FollowMapper());
		return follows;
	}

	public List<Follow> coverlookfollow(String account) {
		// 查看粉丝
		String SQL = "select * from follow where coveraccount = '"+ account +"'";
		List<Follow> follows = jdbcTemplateObject.query(SQL, new FollowMapper());
		return follows;
	}

}
