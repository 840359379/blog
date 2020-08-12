package dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class GoodJDBC implements GoodDao{
	private JdbcTemplate jdbcTemplateObject;
	
	
	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	public void addgood(String number, String account) {
		//点赞
		
	}

	public void deletegood(String number, String account) {
		//取消点赞
		
	}

	public List<Good> lookgoodat(String account) {
		//根据用户查看点赞
		String SQL = "select * from good where account = '"+ account +"'";
		List<Good> goods = jdbcTemplateObject.query(SQL, new GoodMapper());
		return goods;
	}

	public List<Good> lookgoodnr(String number) {
		String SQL = "select * from good where number = '"+ number +"'";
		List<Good> goods = jdbcTemplateObject.query(SQL, new GoodMapper());
		return goods;
	}

}
