package dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


public class UserJDBCtemplate implements UserDao{
	private JdbcTemplate jdbcTemplateObject;

	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}
	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}
	//登录
	public User record(String id,String pw) {
		String SQL = "select * from user where account = '"+ id +"'and password ='"+pw+"'";
		List<User> user = jdbcTemplateObject.query(SQL,new UserMapper());
		if(!user.isEmpty()) {
			return user.get(0);
		}else {
			return null;
		}
	}
	public boolean register() {
		return true;
	}
	
	//修改资料
	public void modify(String id,String column,String cover,String originalcover){
		if(cover.equals(originalcover) != true) {
		String SQL = "UPDATE user SET " + column + "=? WHERE account=?;";
		jdbcTemplateObject.update(SQL,cover,id);
		}
	}
	//用户名查找
	public User chaname(String id) {
		String SQL = "select * from user where account = '"+ id +"'";
		User user = jdbcTemplateObject.queryForObject(SQL,new UserMapper());
		return user;
	}
}
