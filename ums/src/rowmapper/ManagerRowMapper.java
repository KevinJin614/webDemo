package rowmapper;

import java.sql.ResultSet;

import entity.Manager;

import util.RowMapper;

public class ManagerRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs) throws Exception {
		Manager manager = new Manager();
		manager.setId(rs.getInt("id"));
		manager.setUsername(rs.getString("username"));
		manager.setPassword(rs.getString("password"));
		return manager;
	}

}
