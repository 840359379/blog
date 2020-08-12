package dao;

import java.util.List;

public interface InvitationDao {
	//发帖子
	public void publishinvitation(String number,String account,String time,String title,String subtitle,String text);
	//删帖子
	public void deleteinvitation();
	//查看帖子
	public Invitation lookinvitation(String number);
	//查看我的帖子
	public List<Invitation> lookmyinvitations(String account);
	//找帖子
	public List<Invitation> seekinvitations(String name);
	//展示所有帖子
	public List<Invitation> lookinvitations();
}
