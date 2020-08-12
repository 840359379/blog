package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GoodMapper implements RowMapper<Good>{

	public Good mapRow(ResultSet rs, int rowNum) throws SQLException {
		Good good = new Good();
		good.setAccount(rs.getString("account"));
		good.setNumber(rs.getString("number"));
		return good;
	}

}
