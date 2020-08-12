package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class InvitationMapper implements RowMapper<Invitation>{

	public Invitation mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Invitation invitation = new Invitation();
		invitation.setNumber(rs.getString("number"));
		invitation.setAccount(rs.getString("account"));
		invitation.setTime(rs.getString("time"));
		invitation.setTitle(rs.getString("title"));
		invitation.setSubtitle(rs.getString("subtitle"));
		invitation.setText(rs.getString("text"));
		return invitation;
	}

}
