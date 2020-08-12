package dao;

import java.util.List;

public interface FollowDao {
	//添加关注
	public void addfollow(String account,String coveraccount,String name,String covername);
	//删除关注
	public void deletefollow(String account,String coveraccount);
	//查看关注
	public List<Follow> lookfollow(String account);
	//查看粉丝
	public List<Follow> coverlookfollow(String account);
}
