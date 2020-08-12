package dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class InvitationJDBC implements InvitationDao{
	private JdbcTemplate jdbcTemplateObject;
	
	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	public void publishinvitation(String number,String account,String time,String title,String subtitle,String text) {
		//发帖子
		String SQL = "INSERT INTO invitation VALUES (?, ?, ?, ?, ?, ?);";
		jdbcTemplateObject.update(SQL,number,account,time,title,subtitle,text);
	}

	public void deleteinvitation() {
		//删帖子
		
	}

	public Invitation lookinvitation(String number) {
		//查看帖子
		String SQL = "select * from invitation where number = '"+ number +"'";
		List<Invitation> invitations = jdbcTemplateObject.query(SQL,new InvitationMapper());
		if(!invitations.isEmpty()) {
			return invitations.get(0);
		}else {
			return null;
		}
	}
		//展示所有帖子
	public List<Invitation> lookinvitations(){
		String SQL = "select * from invitation";
		List<Invitation> invitations = jdbcTemplateObject.query(SQL,new InvitationMapper());
		return invitations;
	}

	public List<Invitation> lookmyinvitations(String account) {
		// 寻找我的帖子
		String SQL = "select * from invitation where account =  '" + account + "'";
		List<Invitation> invitations = jdbcTemplateObject.query(SQL,new InvitationMapper());
		return invitations;
	}

	public List<Invitation> seekinvitations(String name) {
		// 搜索帖子
		String SQL = "select * from invitation where (title like '%" + name + "%') or (subtitle like '%"+name+"%')";
		List<Invitation> invitations = jdbcTemplateObject.query(SQL,new InvitationMapper());
//		System.out.println(invitations);
		return invitations;
	}
}
