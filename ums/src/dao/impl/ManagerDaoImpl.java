package dao.impl;

import java.util.List;

import rowmapper.ManagerRowMapper;
import util.JDBCTemplate;
import dao.ManagerDao;
import entity.Manager;

public class ManagerDaoImpl implements ManagerDao{

	private JDBCTemplate template;
	public ManagerDaoImpl(){
		template = new JDBCTemplate();
	}
	public Manager selectByUsernameAndPassword(String username, String password) {
		String sql = new StringBuffer()
			.append("select * ")
			.append("from t_manager ")
			.append("where username=? ")
			.append("and password=?")
			.toString();
		List<Manager> managers = template.query(sql, new ManagerRowMapper(), username,password);
		return managers.size()==0?null:managers.get(0);
	}

}
