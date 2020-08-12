package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FollowMapper implements RowMapper<Follow>{

	public Follow mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Follow follow = new Follow();
		follow.setAccount(rs.getString("account"));
		follow.setCoveraccount(rs.getString("coveraccount"));
		follow.setName(rs.getString("name"));
		follow.setCovername(rs.getString("covername"));
		return follow;
	}

}
